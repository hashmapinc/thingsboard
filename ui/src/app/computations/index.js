/*
 * Copyright © 2016-2017 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* eslint-disable import/no-unresolved, import/default */
import uiRouter from 'angular-ui-router';
import thingsboardApiComputation from '../api/computation.service';
import ComputationsController from './computations.controller';
import ComputationUploadDirective from './computation-upload.directive';
import ComputationRoutes from './computation.routes';
/* eslint-enable import/no-unresolved, import/default */

export default angular.module('thingsboard.computation', [
    uiRouter,
    thingsboardApiComputation
])
    .config(ComputationRoutes)
    .controller('ComputationsController', ComputationsController)
    .directive('fileModel', ComputationUploadDirective)
    .name;