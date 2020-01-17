'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('MainCtrl', function($scope, $http,$compile) {
    $scope.dataFromServer = "nic nie ma";
    $scope.textToProcess = "";
    $scope.ShowText = "";
    var nazwa = window.location.href;
    nazwa = nazwa.substring(0, nthIndex(nazwa, "/", 3)+1)
    function nthIndex(str, pat, n){
      var L= str.length, i= -1;
      while(n-- && i++<L){
          i= str.indexOf(pat, i);
          if (i < 0) break;
      }
      return i;
  }
//    var nazwa = "https://myfirstspringapp.herokuapp.com/";
    var data;
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];


    var req = {
      method: 'GET',
      url: nazwa + 'next',
      headers: {
        "Content-Type": "application/json"
      }
    }

    $scope.process = function() {
      var reqText = {
        method: 'GET',
        url: nazwa + 'getUsers',
        headers: {
          "Content-Type": "application/json"
        },
      }
      var startProccesing = $http(reqText).then(function(response) {        
        $scope.ShowText = response.data;       
      })
    }


    var pobieranieDanych = $http(req).then(function(response) {
      $scope.dataFromServer = response.data.name;
    })
  });