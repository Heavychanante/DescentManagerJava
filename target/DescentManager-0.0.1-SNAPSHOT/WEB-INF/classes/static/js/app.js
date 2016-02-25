'use strict';

angular.module('descentManagerApp', [
	'ui.router',
	'ui.bootstrap',
	'ngRoute'
])
.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
    $urlRouterProvider.otherwise('/');
});