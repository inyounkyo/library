Bupyeong.common = (function ( $ ) {

    return {
        aa : function () {
            return $.fn.jquery;
        },
        bb : function (s) {
            console.log(s);
        },
        cc :function(){
            $.each([ 52, 97 ], function( index, value ) {
                console.log( index + ": " + value );
            });
        }
    };

})($);