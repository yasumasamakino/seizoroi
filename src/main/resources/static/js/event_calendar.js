$(function(){
    $('#datepicker').datepicker({
        dateFormat: "yy/mm/dd",
        onSelect: function (selectedDate) {
            var candidateTime = $("#candidateTime").val();
            var existDate = $("#candidateDate").val();
            var addDate =  selectedDate + ' ' + candidateTime + '〜' + '\n';
            if (!existDate.trim()) {
                $('#candidateDate').val(addDate);
            } else {
                $('#candidateDate').val(existDate + addDate);
            }
        }
    });

});
