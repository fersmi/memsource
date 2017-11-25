$(document).ready(
		function() {
			$.getJSON("/api/projects", function(data) {
				var items = [];
				$.each(data, function(index, element) {
					items.push("<tr>" +
							"<td>" + element.name + "</td>" +
							"<td>" + element.status + "</td>" +
							"<td>" + element.sourceLang + "</td>" +
							"<td>" + element.targetLangs + "</td></tr>");
				});

				if (items.length > 0) {
					$table = $( "<table>", {
						"class": "table table-bordered table-striped",
						html: items.join( "" )
					})
					drawRow($table);
					$("#project-list").replaceWith($table);

				} else {
					$("#project-list").replaceWith("<p class='alert alert-warning'>No data found</p>");
				}
			});
		});


function drawRow($table) {
	var $thead = $("<thead />");
	$table.append($thead);

	var $row = $("<tr />");
	$thead.append($row);

    $row.append($("<th>Name</th>"));
    $row.append($("<th>Status</th>"));
    $row.append($("<th>Source language</th>"));
    $row.append($("<th>Target language</th>"));
}