jQuery(document).ready(function () {
    jQuery('.imghover').hover(
            function () {
                jQuery(this).find('.caption').show();
            },
            function () {
                jQuery(this).find('.caption').hide();
            }
    );
});


