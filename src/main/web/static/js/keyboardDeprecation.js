function disableF5(e) {
    if ((e.which || e.keyCode) == 116) e.preventDefault();
};
// To disable f5
/* jQuery < 1.7 */
function Disable() {
    //$(document).bind("keydown", disableF5);
    /* OR jQuery >= 1.7 */
    $(document).on("keydown", disableF5);
    alert( 'Cannot use F5 on this page!');
}

