function obtainStatus() {
    $.ajax({
        url: "http://localhost:8080/api/Reservation/report-status",
        type: "GET",
        dataType: "json",
        success: function (answer) {
            console.log(answer)
            $(".reservComplete").val("")
            //$(".reservComplete").append(drawStatus(answer));
      },
    })
}
function drawStatus(reservs) {
}

function obtainReservCount() {
    let date1 = $("#startTimeReserv").val()
    let date2 = $("#endTimeReserv").val()
  $.ajax({
    url: "http://localhost:8080/api/Reservation/report-dates/" + date1+"/"+date2,
    type: "GET",
    dataType: "json",
    success: function (answer) {
      console.log(answer);
      //$(".countReserv").val("");
      //$(".countReserv").append(drawCountReserv(answer));
    },
  })
}
function drawCountReserv(reservs) {
}

function obtainReservDates() {
  $.ajax({
    url: "http://localhost:8080/api/Reservation/report-clients",
    type: "GET",
    dataType: "json",
    success: function (answer) {
      console.log(answer);
      //$(".reservComplete").val("");
      //$(".reservComplete").append(drawStatus(answer));
    },
  })
}
function drawBestClients(clients) {
}