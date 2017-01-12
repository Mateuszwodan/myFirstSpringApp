'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('AboutCtrl', function ($scope, $http, $compile) {
      $scope.daneZSerwera = [];
      $scope.dodawaniePlatnosci = false;
      $scope.uzytkownicy = [];

      var req = {
        method: 'GET',
        url: 'http://localhost:8080/getTransactions',
        headers: {
          "Content-Type": "application/json"
        }
      }
      var pobieranieDanych = $http(req).then(function (response) {
        $scope.daneZSerwera = response.data;
      })
      var req1 = {
        method: 'GET',
        url: 'http://localhost:8080/getUsers123',
        headers: {
          "Content-Type": "application/json"
        }
      }
      var pobieranieUzytkownikow = $http(req1).then(function (response) {
        $scope.uzytkownicy = response.data;
      })
      $scope.dodajPlatnosc = function () {
        $scope.dodawaniePlatnosci = !$scope.dodawaniePlatnosci;
      }
      $scope.zapiszPlatnosc = function () {
        var req = {
          method: 'POST',
          url: 'http://localhost:8080/saveTransactions',
          headers: {
            "Content-Type": "application/json"
          },
          data: {
            "debtor": $scope.biorca,
            "creditor": $scope.dawca,
            "debt": $scope.kwota,
            "description": "cos tam"
          }
        };
        var saveTransaction = $http(req).then(function (response) {
            $scope.komunikat = response.data.text;
          });
        }
      });
