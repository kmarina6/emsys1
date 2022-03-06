/**
 *
 */
 console.log('ki_inquiry1  ');
// 「コレを選択」ボタンをクリックしたら
$(".selectBtn").on("click", function(){
    var name1 = $(this).closest('tr').find('input').val();
    var name2 = $(this).closest('tr').find('input[name=name]').val();
    var name3 = $(this).closest('tr').children("td").children('input').val();

	var no1 = $(this).closest('tr').children("td")[0].innerText;
	var no2 = $(this).closest('tr').children("td").first().text();

	// まず隠しフィールド要素を取得
	const hiddenField = document.getElementById('emp-no-id');
	// 値をセット
	hiddenField.value = no1

	console.log('ki_inquiry  ');
});

var goDetail = function(emp_no) {
	var no1 = $(this).closest('tr').children("td")[0].innerText;
	var no2 = $(this).closest('tr').children("td").first().text();

	document.getElementById("emp-no-id").value = emp_no;
	document.forms[0].submit();
}