import cx_Oracle
import argparse

def dbConnForOralce(libCd):
    con = cx_Oracle.connect("kknd", "1234", "192.168.126.1/XE",encoding = "UTF-8", nencoding = "UTF-8")
    cur = con.cursor()
    sql = """SELECT a.m_idx, a.m_pidx, a.m_url, a.m_urlnm ,a.m_accessauth, a.m_sort, LEVEL as lev 
    FROM MENU A 
    where a.LIB_CD = :libCd
    START WITH A.M_PIDX IS NULL
    CONNECT BY PRIOR A.M_IDX = A.M_PIDX
    ORDER SIBLINGS BY A.M_SORT"""
    # cur.execute(sql)
    cur.execute(sql, {'libCd': libCd})
    menuList = []
    for result in cur:
        menuList.append(result)
        # print(result)
    cur.close()
    con.close()
    # print(menuList)
    return menuList

class CreateNav:

    def __init__(self, args):
        self.htmlTagGNB = None
        self.htmlTagLNB = None
        self.libCd = args.LIB_CD
        self.libLoc = args.LIB_LOC
        self.saveDirPath = args.saveDirPath
        self.navArr = [args.LIB_GNB, args.LIB_LNB];
        self.menuTuples = dbConnForOralce(args.LIB_CD)

    def commandBlockFactory(self):

        def createNavGNB( bsl ):
            ht=None
            # print('1depth:::',bsl)
            ht='<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>'
            ht+='<ul>'
            for k1 in bsl.keys():
                # print(k, bsl[k])
                # ht+='<a href=\''+str(bsl[k][0][2])+'\'>'+str(bsl[k1][0][3])+'</a>'
                ht+='<li class="dropdown">' \
                    '<a href="javascript:void(0)" class="dropbtn">'+str(bsl[k1][0][3])+'</a>' \
                    '<div class="dropdown-content">'
                for k2 in bsl[k1]:
                    if k2[6] == 2:
                        ht+='<a href=\''+k2[2]+'\'>'+str(k2[3])+'</a>'
                ht+='</div>'
                ht+='</li>'
            ht+='</ul>'
            # print(ht)
            return ht

        def createNavLNB( bsl ):
            ht=None
            ht='<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>'
            ht+='<nav class="navigation">'
            ht+='<ul class="mainmenu">'

            for k1 in bsl[str(0)]:
                if k1[6] == 2:
                    lv3 = [x for x in bsl[str(0)] if x[1]==k1[0]]
                    ht+='<li menu-idx=\''+str(k1[0])+'\'><a href=\''+k1[2]+'\'>'+str(k1[3])+'</a></li>'

                    for idx2, k2 in enumerate(lv3):
                        if idx2 == 0:
                            ht+='<li ><a href="#" class="hasChildMark">'+str(k1[3])+'</a>'
                            ht+='<ul class="submenu">'

                        ht+='<li menu-idx=\''+str(k2[0])+'\'><a href=\''+k2[2]+'\'>'+str(k2[3])+'</a></li>'

                        if len(lv3[idx2]) == idx2:
                            ht+='</ul>'
                            ht+='</li>'
            ht+='</ul>'
            ht+='</nav>'
            return ht;

        def divideTuble():
            __blockSetList__ = {}
            tupleIdx = []
            for idx, t in enumerate(self.menuTuples):
                if t[6] == 1: tupleIdx.append(idx)
            tupleIdx.append(len(self.menuTuples))
            # print(tupleIdx)
            # print( self.menuTuples[tupleIdx[7]] )
            for i in range(len(tupleIdx)-1):
                __blockSetList__[str(tupleIdx[i])] = list(self.menuTuples[tupleIdx[i]:tupleIdx[i+1]])
                # print( self.menuTuples[tupleIdx[i]:tupleIdx[i+1]] )
            return __blockSetList__

        blockSetList = divideTuble()

        self.htmlTagGNB = createNavGNB(blockSetList)
        self.htmlTagLNB = createNavLNB(blockSetList)
        print(self.htmlTagGNB)
        # print(self.htmlTagLNB)

    def fileWrite(self):
        # print(os.getcwd())
        for i, nav in enumerate(self.navArr):
            fileNM = self.saveDirPath.replace("++", self.libLoc)+nav
            self.fo = open(fileNM, mode="w", encoding="utf8")
            self.fo.write( [self.htmlTagGNB, self.htmlTagLNB][i] )
            self.fo.close()

def receiveCallJavaArgs():
    parser = argparse.ArgumentParser(description='LIB_LOC, LIB_CD, saveDirPath, LIB_GNB, LIB_LNB')
    parser.add_argument("LIB_LOC", help="", type=str)
    parser.add_argument("LIB_CD", help="", type=str)
    parser.add_argument("saveDirPath", help="saveing menu(HTML FILE) to physical path", type=str)
    parser.add_argument("LIB_GNB", help="nav GNB", type=str)
    parser.add_argument("LIB_LNB", help="nav LNB", type=str)
    args = parser.parse_args()
    print(args)
    # print(args.LIB_LOC)
    # print(args.LIB_CD)

    cnIns = CreateNav(args)
    cnIns.commandBlockFactory();
    cnIns.fileWrite()

receiveCallJavaArgs()
