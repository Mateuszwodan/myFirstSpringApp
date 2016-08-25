'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('MainCtrl', function ($scope, $http) {  
      $scope.dataFromServer = "nic nie ma";

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


    var pobieranieDanych = $http(req).then(function(response) {
      $scope.dataFromServer = response.data.name;
    })
  });
