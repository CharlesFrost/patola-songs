$(document).ready(
		function() {
		/////////////////////////////////////

		//////////////////////////////////////
			// SUBMIT FORM
			$("#submitData").click(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();

			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					link : $("#link").val(),
					deltePassword : $("#deletePassword").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "song",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							alert("Udało Ci się dodac piosenkę");
							// var text = "<div class=\"card\"><img src=\"https://nasionbank.pl/images/Topy_marihuany/top_marihuany_1.jpg\" width=\"100\" height=\"300\" class=\"card-img-top\" alt=\"...\"><div class=\"card-body\"><h5 class=\"card-title\">"+result.data.name+"</h5><p class=\"card-text\"><p>"+result.data.author+"</p><p class=\"card-text\"><small class=\"text-muted\">"+result.data.releaseYear+"</small></p></div></div>";
							// $('#getResultDiv1').append(text);
						} else {
							 alert("Uknown error");
						}
						console.log(result);
					},
					error : function(e) {
						var errorsText = "";
						for (i = 0; i < e.responseJSON.errors.length; i++) {
                          errorsText += e.responseJSON.errors[i].defaultMessage + "\n";
                        }
                        alert(errorsText)
						console.log("ERROR: ", e);
					}
				});

			}

		})