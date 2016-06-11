jQuery(document).ready(function () {
    jQuery(".reg").click(function () {
        jQuery.ajax({url: "terms.html", success: function (result) {
                jQuery("#div1").html(result);
            }});
    });
});


