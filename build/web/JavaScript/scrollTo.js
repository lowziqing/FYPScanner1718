function scroll_to_div(id) {
    $('html,body').animate({
        scrollTop: $("#" + id).offset().top
    },
            'slow');
}

