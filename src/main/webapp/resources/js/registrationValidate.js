$(document).ready(function() {
	
    $('#registerForm').validate({ // initialize the plugin
        rules: {
            login: {
                required: true,
                minlength: 4
            },
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 6
            }
        }
    });
});