function processContactForm(e) {
  e.preventDefault();
  $("#contact-confirmation").show("slow");
  return false;
}

// Function to check Whether both passwords is same or not.
function checkPasswords(form) {
    password1 = form.password.value;
    password2 = form.password2.value;

    if (password1 != password2) {
        document.getElementById("invalidatedPasswords").innerHTML = "Passwords do not match! <br/>";
        return false;
    } else{
        return true;
    }
}

$(document).ready(function () {
    $(".moreBox").slice(0, 10).show();
    if ($(".bookBox:hidden").length != 0) {
        $("#loadMore").show();
    }
    $("#loadMore").on('click', function (e) {
        e.preventDefault();
        $(".moreBox:hidden").slice(0, 5).slideDown();
        if ($(".moreBox:hidden").length == 0) {
            $("#loadMore").fadeOut('slow');
        }
    });
});