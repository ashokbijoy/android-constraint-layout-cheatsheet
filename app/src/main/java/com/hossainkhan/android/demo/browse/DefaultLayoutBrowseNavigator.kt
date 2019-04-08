/*
 * Copyright (c) 2019 Hossain Khan
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

package com.hossainkhan.android.demo.browse

import android.content.Context
import android.content.Intent
import com.hossainkhan.android.demo.layoutpreview.LayoutPreviewBaseActivity
import javax.inject.Inject

class DefaultLayoutBrowseNavigator @Inject constructor(private val context: Context) : LayoutBrowseNavigator {
    override fun loadLayoutPreview(layoutResId: Int) {
        val startIntent = LayoutPreviewBaseActivity.createStartIntent(context, layoutResId)
        // FIX IT: android.util.AndroidRuntimeException: Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?
        startIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(startIntent)
    }

    override fun <T> loadLayoutPreview(clazz: Class<T>, layoutResId: Int) {
        val startIntent = LayoutPreviewBaseActivity.createStartIntent(context, clazz, layoutResId)
        // FIX IT: android.util.AndroidRuntimeException: Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?
        startIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(startIntent)
    }
}