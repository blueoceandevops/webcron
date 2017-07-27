'use strict';

angular.module('webCronApp')
    .service('JobsService', function ($http, $cookies) {
        /**
         * @returns Promisse
         */
        this.listJobs = function (page, limit) {
            var req = {
                method: 'GET',
                url: '/jobs/all',
                params: {page: (page - 1), limit: limit},
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'X-XSRF-TOKEN': $cookies.get('XSRF-TOKEN')
                }
            };
            return $http(req);
        };

        /**
         * @returns Promisse
         */
        this.save = function (job) {
            var req = {
                method: 'POST',
                url: '/jobs/create',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'X-XSRF-TOKEN': $cookies.get('XSRF-TOKEN')
                },
                data: job
            };
            return $http(req);
        };
    });