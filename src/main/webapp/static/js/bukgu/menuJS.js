Bukgu.menu = (function ( $ ) {
   return {
        click : function () {
            $("li").click(function(e){
                    e.stopPropagation();
                    var eCurrTarget = e.currentTarget;
                    var hasSubMenu = $(eCurrTarget).closest('ul').hasClass('submenu');
                    $('.mainmenu').children().each(function(i,el){
                        $(el).removeClass('on');
                        $(el).find('ul').removeClass('off');
                        if($(el).children().hasClass('submenu')){
                            $(el).find('a').eq(0).addClass('hasChildMark');
                        }
                        $(el).find('ul').children().each(function(i,el){
                            $(el).removeClass('on');
                        });
                    });
                    if(hasSubMenu) $(eCurrTarget).closest('ul').addClass('off');
                    $(eCurrTarget).closest('ul').closest('li').find('a').removeClass('hasChildMark');
                    if(!$(eCurrTarget).children().hasClass('submenu')){
                        $(eCurrTarget).addClass('on');
                    }
            });
        },
       autoSelect: function( menuIdx ){
           var currEl = $('li').filter(function(){
               if( $(this).attr('menu-idx') == menuIdx ){ return this; }
           });
           $(currEl[0]).addClass('on');
           if( $(currEl[0]).closest('ul').hasClass('submenu') ){
               $(currEl[0]).closest('ul').addClass('off');
               $(currEl[0]).closest('ul').closest('li').find('a').removeClass('hasChildMark');
           }
       },

        bb : function () {
            alert("menu bb");
        }
    };
})($);

