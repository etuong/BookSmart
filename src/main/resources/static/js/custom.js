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