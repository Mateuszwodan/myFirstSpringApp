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
    var data;
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];


    var req = {
      method: 'GET',
      url: 'http://localhost:8080/next',
      headers: {
        "Content-Type": "application/json"
      }
    }

    $scope.process = function() {
      var reqText = {
        method: 'POST',
        url: 'http://localhost:8080/googleIt',
        headers: {
          "Content-Type": "application/json"
        },
        data: {
          text: $scope.textToProcess
        }
      }
      var startProccesing = $http(reqText).then(function(response) {
        data = response.data.text;
       // data = data.replace(/<script>/g,"<scroipt>");
       // data = data.replace(/<\/script>/g,"</scroipt>");
       // data = data.replace(/<style>/g,"<styole>");
       // data = data.replace(/<\/style>/g,"</styole>");
        var linkingFunction = $compile(data);
        angular.element(document.getElementById('ShowText')).append(linkingFunction($scope));
      })
    }


    var pobieranieDanych = $http(req).then(function(response) {
      $scope.dataFromServer = response.data.name;
    })
  });