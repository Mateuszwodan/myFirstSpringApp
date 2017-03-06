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
    $scope.dodawaniePlatnosci = true;
    $scope.dodawanieUzytkownika = true;
    $scope.uzytkownicy = [];
    //var nazwa = "http://localhost:8080/";
    var nazwa = "https://myfirstspringapp.herokuapp.com/";

    var req = {
      method: 'GET',
      url: nazwa + 'getTransactions',
      headers: {
        "Content-Type": "application/json"
      }
    }
    var pobieranieDanych = $http(req).then(function (response) {
      $scope.daneZSerwera = response.data;
    })
    var req1 = {
      method: 'GET',
      url: nazwa + 'getUsers123',
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
     $scope.dodajUzytkownika = function () {
      $scope.dodawanieUzytkownika = !$scope.dodawanieUzytkownika;
    }
    $scope.zapiszPlatnosc = function () {
      var req12 = {
        method: 'POST',
        url: nazwa + 'saveTransaction',
        headers: {
          'Content-Type': 'application/json'
        },
        data: {
          "debtor": {
            "username": $scope.biorca.username,
            "password": " ",
            "enabled": true,
          },
          "creditor": {
            "username": $scope.dawca.username,
            "password": " ",
            "enabled": true,
          },
          "debt": $scope.kwota,
          "description": $scope.opis,

        }
      };
         var req = {
      method: 'GET',
      url: nazwa + 'getTransactions',
      headers: {
        "Content-Type": "application/json"
      }
    }
      var saveTransaction = $http(req12).then(function (response) {
        $scope.komunikat = response.data.text;
         var pobieranieDanych = $http(req).then(function (response) {
      $scope.daneZSerwera = response.data;
      scope.$apply();
    })
      });
    
     
    }
    $scope.removeRow = function(index) {
      var req15 = {
        method: 'POST',
        url: nazwa + 'deleteTransaction',
        headers: {
          'Content-Type': 'application/json'
        },
        data: {
          "debtor": {
            "username": $scope.daneZSerwera[index].debtor.username,
            "password": " ",
            "enabled": true,
          },
          "creditor": {
            "username": $scope.daneZSerwera[index].creditor.username,
            "password": " ",
            "enabled": true,
          },
          "debt": $scope.daneZSerwera[index].debt,
          "description": "xxx",
          "id" : $scope.daneZSerwera[index].id

        }
      };
       var req = {
      method: 'GET',
      url: nazwa + 'getTransactions',
      headers: {
        "Content-Type": "application/json"
      }
    }
      var saveTransaction = $http(req15).then(function (response) {
        $scope.komunikat = response.data.text;
         var pobieranieDanych = $http(req).then(function (response) {
      $scope.daneZSerwera = response.data;
      scope.$apply();
    })
      });
      
     
    }
    $scope.zapiszUzytkownika = function () {
      var req17 = {
        method: 'POST',
        url: nazwa + 'saveUser',
        headers: {
          'Content-Type': 'application/json'
        },
        data: {
            "username": $scope.nowy_uzytkownik,
            "password": " ",
            "enabled": true,
          }
      };
            var req1 = {
      method: 'GET',
      url: nazwa + 'getUsers123',
      headers: {
        "Content-Type": "application/json"
      }
    }
    var pobieranieUzytkownikow = $http(req1).then(function (response) {
      $scope.uzytkownicy = response.data;
    })
      var saveTransaction = $http(req17).then(function (response) {
        $scope.komunikat = response.data.text;
           var pobieranieUzytkownikow = $http(req1).then(function (response) {
      $scope.uzytkownicy = response.data;
      $scope.$apply();
    })
      });
    
     
    }
    
  });
