jQuery(document).ready(function() {
    function close_accordion_section() {
        jQuery('.accordion .accordion-title').removeClass('active');
        jQuery('.accordion .accordion-content').slideUp(300).removeClass('open');
    }
 
    jQuery('.accordion-title').click(function(e) {
        var currentAttrValue = $(this).attr('href');
 
        if(jQuery(e.target).is('.active')) {
            close_accordion_section();
        }
        else 
        {
            close_accordion_section();
            jQuery(this).addClass('active');
            jQuery('.accordion ' + currentAttrValue).slideDown(300).addClass('open'); 
        }
 
        e.preventDefault();
    });
});