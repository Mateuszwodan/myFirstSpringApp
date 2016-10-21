'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('MainCtrl', function($scope, $http) {
    $scope.dataFromServer = "nic nie ma";
    $scope.textToProcess = "";

    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];


    var req = {
      method: 'GET',
      url: 'https://boiling-springs-13455.herokuapp.com/next',
      headers: {
        "Content-Type": "application/json"
      }
    }

    $scope.process = function() {
      var reqText = {
        method: 'POST',
        url: 'https://boiling-springs-13455.herokuapp.com/processText',
        headers: {
          "Content-Type": "application/json"
        },
        data: {
          text: $scope.textToProcess
        }
      }
      var startProccesing = $http(reqText).then(function(response) {
        $scope.textToProcess = response.data.text;
      })
    }


    var pobieranieDanych = $http(req).then(function(response) {
      $scope.dataFromServer = response.data.name;
    })
  });