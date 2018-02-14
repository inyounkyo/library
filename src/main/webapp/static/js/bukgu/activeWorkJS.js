Bukgu.activeWork = (function ( $ ) {

    return {
        aa : function () {
            return $.fn.jquery;
        },
        bb : function (s) {
            console.log(s);
        },
        cc :function(){
            $.each([ 1, 2 ,3,4,5,6,7,8], function( index, value ) {
                console.log( index + ": " + value );
            });
        }
    };

})($);


