'use strict';

angular.module('descentManagerApp', [
	'ui.router',
	'ui.bootstrap',
	'ngRoute'
])
.config(function($stateProvider, $urlRouterProvider, $httpProvider) {
    $urlRouterProvider.otherwise('/');
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
})

//Este método se ejecutará cada vez que cambie el estado de navegación
// Comprobará si el usuario está logueado y si no es así redirigirá a la página de login
.run(function($rootScope, $http, $state) {
	/**
  $rootScope.alertMessage = '';
  $rootScope.showAlertMessage = false;
  $rootScope.showLoader = false;

  $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams){
    if (toState.url !== '/register' && toState.url !== '/login') {
      $http.get('/DescentManager/loggedin')
        .then(function(response){
          $rootScope.loginErrorMessage = null;

          // Usuario autenticado
          if (response.data !== '0') {
            $rootScope.currentUser = response.data;
          } else {
            // Ususario no autenticado
            $rootScope.loginErrorMessage = 'Debes hacer login';
            event.preventDefault();
            $state.go('login');
          }
        }, function(response){
          console.error(response.status);
        });
    }
  });
  */
});