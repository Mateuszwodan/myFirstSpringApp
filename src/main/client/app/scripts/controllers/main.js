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
    var nazwa = "https://myfirstspringapp.herokuapp.com/";
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