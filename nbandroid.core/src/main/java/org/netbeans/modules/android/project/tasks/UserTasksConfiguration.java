/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.android.project.tasks;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeListener;
import nbandroid.gradle.spi.GradleCommandTemplate;
import nbandroid.gradle.spi.GradleUserTaskProvider;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.AuxiliaryProperties;
import org.openide.util.ChangeSupport;

/**
 *
 * @author arsi
 */
public class UserTasksConfiguration implements GradleUserTaskProvider {

    private final Project project;
    private final AuxiliaryProperties auxProps;
    private final List<UserTask> userTasks = new ArrayList<>();
    public static final String GRADLE_PROJECT_USER_TASKS = "GRADLE_PROJECT_USER_TASKS";
    private final ChangeSupport changeSupport = new ChangeSupport(this);

    public UserTasksConfiguration(Project project) {
        this.project = project;
        auxProps = project.getLookup().lookup(AuxiliaryProperties.class);
        read();
    }

    public final void read() {
        userTasks.clear();
        String s = auxProps.get(GRADLE_PROJECT_USER_TASKS, false);
        if (s != null) {
            userTasks.addAll(UserTask.stringToList(s));
        }
        changeSupport.fireChange();
    }

    public final void store() {
        auxProps.put(GRADLE_PROJECT_USER_TASKS, UserTask.listToString(userTasks), false);
        changeSupport.fireChange();
    }

    public List<UserTask> getUserTasks() {
        return userTasks;
    }

    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        changeSupport.removeChangeListener(listener);
    }

    @Override
    public List<GradleCommandTemplate> getGradleUserTasks() {
        List<GradleCommandTemplate> tmp = new ArrayList<>();
        for (UserTask userTask : userTasks) {
            tmp.add(userTask.getCommandTemplate());
        }
        return tmp;
    }

}
