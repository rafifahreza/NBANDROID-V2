/*
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
package org.nbandroid.netbeans.gradle.api;

import javax.annotation.Nullable;
import javax.swing.event.ChangeListener;
import org.openide.filesystems.FileObject;

// TODO radim: should be a function: source fileobject -> manifest fileobject to allow for different AM.xml for flavors/configs
/**
 *
 * @author radim
 */
public interface AndroidManifestSource {

    @Nullable
    FileObject get();

    public void addChangeListener(ChangeListener listener);

    public void removeChangeListener(ChangeListener listener);
}
