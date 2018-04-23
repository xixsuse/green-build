/*
 * Copyright 2018 Keval Patel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kevalpatel2106.greenbuild.travisInterface

import com.kevalpatel2106.ci.greenbuild.base.ciInterface.CompatibilityCheck
import timber.log.Timber

/**
 * Created by Keval on 23/04/18.
 * This class provides the compatibility information for the features listed in [CompatibilityCheck]
 * for Travis CI services.
 *
 * @author <a href="https://github.com/kevalpatel2106">kevalpatel2106</a>
 * @see CompatibilityCheck
 */
class TravisCompatibilityCheck : CompatibilityCheck {

    companion object {

        fun get(baseUrl: String): TravisCompatibilityCheck? {
            return when {
                baseUrl == Constants.TRAVIS_CI_ORG -> TravisCompatibilityCheck()
                baseUrl == Constants.TRAVIS_CI_COM -> TravisCompatibilityCheck()
                baseUrl.startsWith("https://travis.") && baseUrl.endsWith("/api/") -> {
                    TravisCompatibilityCheck()
                }
                else -> {
                    Timber.i("Not a travis ci server: $baseUrl")
                    null
                }
            }
        }
    }

    /**
     * Returns true if the CI server provides way to list all the recent builds (for all the repositories)
     * else false.
     */
    override fun isRecentBuildsListSupported() = true

    /**
     * Returns true if the CI server provides way to list all the builds for the repository. Application
     * can retrieve the  builds list by calling [TravisServerInterface.getBuildList].
     *
     * @see TravisServerInterface.getBuildList
     */
    override fun isBuildsListByRepoSupported() = true

    /**
     * Method to check if the CI provider allows to list the environment variables.  Application
     * can retrieve the  builds list by calling [TravisServerInterface.getEnvironmentVariablesList].
     *
     * @return true if the feature is possible.
     * @see TravisServerInterface.getEnvironmentVariablesList
     */
    override fun isEnvironmentVariableListSupported() = true

    /**
     * TODO
     * Method to check if the CI provider allows to delete the environment variables. Application
     * can retrieve the  builds list by calling [TravisServerInterface.getEnvironmentVariablesList].
     *
     * @return true if the feature is possible.
     * @see TravisServerInterface.getEnvironmentVariablesList
     */
    override fun isEnvironmentVariableDeleteSupported() = true

    /**
     * TODO
     * Method to check if the CI provider allows to edit the public environment variables. Application
     * can retrieve the  builds list by calling [TravisServerInterface.getEnvironmentVariablesList].
     *
     * @return true if the feature is possible.
     * @see TravisServerInterface.getEnvironmentVariablesList
     */
    override fun isPublicEnvironmentVariableEditSupported() = true

    /**
     * TODO
     * Method to check if the CI provider allows to edit the private/secrete environment variables.
     * Application can retrieve the  builds list by calling [TravisServerInterface.getEnvironmentVariablesList].
     *
     * @return true if the feature is possible.
     * @see TravisServerInterface.getEnvironmentVariablesList
     */
    override fun isPrivateEnvironmentVariableEditSupported() = true

    /**
     * TODO
     * Method to check if the CI provider allows to list all the cron jobs.  Application
     * can retrieve the  builds list by calling [ServerInterface.getEnvironmentVariablesList].
     *
     * @return true if the feature is possible.
     * @see ServerInterface.getEnvironmentVariablesList
     */
    override fun isCronJobsListSupported() = true

    /**
     * Method to check if the CI provider allows to list all the caches for the repository. Application
     * can retrieve the  builds list by calling [TravisServerInterface.getCachesList].
     *
     * @return true if the feature is possible.
     * @see TravisServerInterface.getCachesList
     */
    override fun isCacheListListSupported() = true

    /**
     * TODO
     * Method to check if the CI provider allows to delete the cache. Application can retrieve the
     * builds list by calling [ServerInterface.getEnvironmentVariablesList].
     *
     * @return true if the feature is possible.
     * @see ServerInterface.getEnvironmentVariablesList
     */
    override fun isCacheDeleteSupported() = true
}