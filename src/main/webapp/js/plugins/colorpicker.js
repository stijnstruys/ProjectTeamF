$(document).ready(function () {
    var f = $.farbtastic('#picker');
    var p = $('#picker').css('opacity', 0.25);
    var selected = null;

    //show which color value you're editing
    $('.colorpicker')
        .each(function () {
            f.linkTo(this);
            $(this).css('opacity', 0.75); })
        .focus(function() {
            if (selected) {
                $(selected).css('opacity', 0.75).removeClass('colorwell-selected');
            }
            f.linkTo(this);
            p.css('opacity', 1);
            $(selected = this).css('opacity', 1).addClass('colorwell-selected');
        }
    );

    //changes values in textfields
    $("#color1").change(function() {
        var color = $("#color1").val();
        $("#content").css("background", color);
    });

    $("#color2").change(function() {
        var color = $("#color2").val();
        $("#content").css("color", color);
    });

    $("#color3").change(function() {
        var color = $("#color3").val();
        $("#content h2").css("color", color);
    });
});
