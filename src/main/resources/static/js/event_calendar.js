$(function(){
    $('#datepicker').datepicker({
        dateFormat: "yy/mm/dd",
        onSelect: function (selectedDate) {
            var candidateTime = $("#proposedTime").val();
            var existDate = $("#proposedDate").val();
            var addDate =  selectedDate + ' ' + candidateTime + '〜' + '\n';
            if (!existDate.trim()) {
                $('#proposedDate').val(addDate);
            } else {
                $('#proposedDate').val(existDate + addDate);
            }
        }
    });

});
