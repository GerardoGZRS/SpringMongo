/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var array = [];
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
       $http({
    method : "GET",
      url : "http://localhost:8080/profesores/checkrest"
  })
  .then(function(response) {
    // First function handles success
    $scope.content = response.data;
 //   console.log($scope.content);
    $scope.content.forEach(element => array.push({ asignatura:element.asignatura, hora:element.hora }));  
  //  array.push({ asignatura: $scope.content.asignatura});
   console.log(array);
    array.forEach(o => {
      console.log(o.asignatura + o.hora);
    });

  }, function(response) {
    // Second function handles error
    $scope.content = "Error no se pudo encontrar!!!";
    
    console.log($scope.content);
  });
});
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

//console.log(array);
// Draw the chart and set the chart values
function drawChart() {
    
    
    var data;
    var arrays = [];
    arrays.push(['tareas', 'works']);
 array.forEach(o => {
    arrays.push([o.asignatura, o.hora]);
     });
     console.log(arrays);
    data = google.visualization.arrayToDataTable(arrays);   
    
   
//console.log(data);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'My Average Day', 'width':550, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
  chart.draw(data, options);
}