/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.nbandroid.netbeans.gradle.v2.project.template;

import com.android.sdklib.SdkVersionInfo;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import org.nbandroid.netbeans.gradle.v2.project.distributions.AndroidDistributionsPanel;
import org.nbandroid.netbeans.gradle.v2.project.distributions.AndroidDistributionsProvider;
import static org.nbandroid.netbeans.gradle.v2.project.template.AndroidProjectTemplatePanelVisualBasicSettings.PROP_PROJECT_DIR;
import static org.nbandroid.netbeans.gradle.v2.project.template.AndroidProjectTemplatePanelVisualBasicSettings.PROP_PROJECT_SDK;
import org.nbandroid.netbeans.gradle.v2.sdk.AndroidPlatformInfo;
import org.nbandroid.netbeans.gradle.v2.sdk.AndroidSdk;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;

public class AndroidProjectTemplatePanelVisualAndroidSettings extends JPanel implements ItemListener, DocumentListener {

    public static final String PROP_PHONE_TABLET_ENABLED = "PROP_PHONE_TABLET_ENABLED";
    public static final String PROP_PHONE_TABLET_PLATFORM = "PROP_PHONE_TABLET_SDK";
    public static final String PROP_PHONE_TABLET_FOLDER = "PROP_PHONE_TABLET_FOLDER";
    public static final String PROP_WEAR_ENABLED = "PROP_WEAR_ENABLED";
    public static final String PROP_WEAR_PLATFORM = "PROP_WEAR_PLATFORM";
    public static final String PROP_WEAR_FOLDER = "PROP_WEAR_FOLDER";
    public static final String PROP_TV_ENABLED = "PROP_TV_ENABLED";
    public static final String PROP_TV_PLATFORM = "PROP_TV_PLATFORM";
    public static final String PROP_TV_FOLDER = "PROP_TV_FOLDER";
    public static final String PROP_AUTO_ENABLED = "PROP_AUTO_ENABLED";
    public static final String PROP_MAX_BUILD_LEVEL = "PROP_MAX_BUILD_LEVEL";
    public static final String PROP_PLATFORM_CONFIG_DONE = "PROP_PLATFORM_CONFIG_DONE";
    private AndroidProjectTemplateWizardPanellVisualAndroidSettings panel;
    private AndroidSdk androidSdk;

    public AndroidProjectTemplatePanelVisualAndroidSettings(AndroidProjectTemplateWizardPanellVisualAndroidSettings panel) {
        initComponents();
        this.panel = panel;
        // Register listener on the textFields to make the automatic updates
        phoneEnabled.addItemListener(this);
        wearEnabled.addItemListener(this);
        tvEnabled.addItemListener(this);
        phonePlatforms.addItemListener(this);
        wearPlatforms.addItemListener(this);
        tvPlatforms.addItemListener(this);
        helpText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                NotifyDescriptor nd = new NotifyDescriptor.Message(new AndroidDistributionsPanel());
                DialogDisplayer.getDefault().notify(nd);
            }

        });
        mobileFolder.getDocument().addDocumentListener(this);
        wearFolder.getDocument().addDocumentListener(this);
        tvFolder.getDocument().addDocumentListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        phoneEnabled = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        phonePlatforms = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        apiHelpText = new javax.swing.JLabel();
        helpText = new javax.swing.JLabel();
        wearEnabled = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        wearPlatforms = new javax.swing.JComboBox<>();
        tvEnabled = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        tvPlatforms = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        mobileFolder = new javax.swing.JTextField();
        wearFolder = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tvFolder = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.jLabel4.text")); // NOI18N

        phoneEnabled.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(phoneEnabled, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.phoneEnabled.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.jLabel5.text")); // NOI18N

        phonePlatforms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.jLabel6.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(apiHelpText, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.apiHelpText.text")); // NOI18N

        helpText.setForeground(new java.awt.Color(0, 51, 255));
        org.openide.awt.Mnemonics.setLocalizedText(helpText, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.helpText.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(wearEnabled, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.wearEnabled.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.jLabel8.text")); // NOI18N

        wearPlatforms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.openide.awt.Mnemonics.setLocalizedText(tvEnabled, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.tvEnabled.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.jLabel9.text")); // NOI18N

        tvPlatforms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.jLabel1.text")); // NOI18N

        mobileFolder.setText(org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.mobileFolder.text")); // NOI18N

        wearFolder.setText(org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.wearFolder.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.jLabel2.text")); // NOI18N

        tvFolder.setText(org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.tvFolder.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(AndroidProjectTemplatePanelVisualAndroidSettings.class, "AndroidProjectTemplatePanelVisualAndroidSettings.jLabel7.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(phonePlatforms, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(apiHelpText)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(helpText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(mobileFolder)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(wearFolder)
                                            .addComponent(wearPlatforms, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tvFolder)
                                            .addComponent(tvPlatforms, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneEnabled)
                                    .addComponent(tvEnabled)
                                    .addComponent(wearEnabled))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(phoneEnabled)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(phonePlatforms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apiHelpText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(mobileFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(wearEnabled)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(wearPlatforms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(wearFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(tvEnabled)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(tvPlatforms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tvFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apiHelpText;
    private javax.swing.JLabel helpText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mobileFolder;
    private javax.swing.JCheckBox phoneEnabled;
    private javax.swing.JComboBox<String> phonePlatforms;
    private javax.swing.JCheckBox tvEnabled;
    private javax.swing.JTextField tvFolder;
    private javax.swing.JComboBox<String> tvPlatforms;
    private javax.swing.JCheckBox wearEnabled;
    private javax.swing.JTextField wearFolder;
    private javax.swing.JComboBox<String> wearPlatforms;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addNotify() {
        super.addNotify();
        //same problem as in 31086, initial focus on Cancel button
        phoneEnabled.requestFocus();
    }

    boolean valid(WizardDescriptor wizardDescriptor) {
        wizardDescriptor.putProperty("WizardPanel_errorMessage", null);
        boolean status = phoneEnabled.isSelected() || wearEnabled.isSelected() || tvEnabled.isSelected();
        if (!status) {
            wizardDescriptor.putProperty("WizardPanel_errorMessage",
                    "You must select at least one option.");
        }
        if (!isFilenameValid(mobileFolder.getText()) && phoneEnabled.isSelected()) {
            wizardDescriptor.putProperty("WizardPanel_errorMessage",
                    "Mobile folder name is not valid!");
            status = false;
        }
        if (!isFilenameValid(wearFolder.getText()) && wearEnabled.isSelected()) {
            wizardDescriptor.putProperty("WizardPanel_errorMessage",
                    "Wear folder name is not valid!");
            status = false;
        }
        if (!isFilenameValid(tvFolder.getText()) && tvEnabled.isSelected()) {
            wizardDescriptor.putProperty("WizardPanel_errorMessage",
                    "TV folder name is not valid!");
            status = false;
        }
        return status;
    }

    void store(WizardDescriptor d) {
        d.putProperty(PROP_PHONE_TABLET_ENABLED, phoneEnabled.isSelected());
        d.putProperty(PROP_WEAR_ENABLED, wearEnabled.isSelected());
        d.putProperty(PROP_TV_ENABLED, tvEnabled.isSelected());
        d.putProperty(PROP_PHONE_TABLET_PLATFORM, phonePlatforms.getSelectedItem());
        d.putProperty(PROP_WEAR_PLATFORM, wearPlatforms.getSelectedItem());
        d.putProperty(PROP_TV_PLATFORM, tvPlatforms.getSelectedItem());
        d.putProperty(PROP_PLATFORM_CONFIG_DONE, new Boolean[]{phoneEnabled.isSelected(), wearEnabled.isSelected(), tvEnabled.isSelected()});
        d.putProperty(PROP_PHONE_TABLET_FOLDER, mobileFolder.getText().trim());
        d.putProperty(PROP_WEAR_FOLDER, wearFolder.getText().trim());
        d.putProperty(PROP_TV_FOLDER, tvFolder.getText().trim());
    }

    private void updateDistribution() {
        AndroidPlatformInfo selectedItem = (AndroidPlatformInfo) phonePlatforms.getSelectedItem();
        int apiLevel = selectedItem.getAndroidVersion().getApiLevel();
        apiHelpText.setText(AndroidDistributionsProvider.getApiHelpText(apiLevel, "" + apiLevel));
    }

    void read(WizardDescriptor settings) {
        androidSdk = (AndroidSdk) settings.getProperty(PROP_PROJECT_SDK);
        List<AndroidPlatformInfo> platforms = new ArrayList<>(androidSdk.getPlatforms());
        platforms.sort(new Comparator<AndroidPlatformInfo>() {
            @Override
            public int compare(AndroidPlatformInfo o1, AndroidPlatformInfo o2) {
                return Integer.compare(o1.getAndroidVersion().getApiLevel(), o2.getAndroidVersion().getApiLevel());
            }
        });
        int maxBuildLevel = 0;
        phonePlatforms.setModel(new DefaultComboBoxModel(platforms.toArray()));
        phonePlatforms.setRenderer(new ComboBoxRenderer());
        for (Iterator<AndroidPlatformInfo> iterator = platforms.iterator(); iterator.hasNext();) {
            AndroidPlatformInfo next = iterator.next();
            if (next.getAndroidVersion().getFeatureLevel() > maxBuildLevel) {
                maxBuildLevel = next.getAndroidVersion().getFeatureLevel();
            }
            if (next.getAndroidVersion().getApiLevel() < 20) {
                iterator.remove();
            }
        }
        settings.putProperty(PROP_MAX_BUILD_LEVEL, maxBuildLevel);
        wearPlatforms.setModel(new DefaultComboBoxModel(platforms.toArray()));
        wearPlatforms.setRenderer(new ComboBoxRenderer());
        for (Iterator<AndroidPlatformInfo> iterator = platforms.iterator(); iterator.hasNext();) {
            AndroidPlatformInfo next = iterator.next();
            if (next.getAndroidVersion().getApiLevel() < 21) {
                iterator.remove();
            }
        }
        tvPlatforms.setModel(new DefaultComboBoxModel(platforms.toArray()));
        tvPlatforms.setRenderer(new ComboBoxRenderer());
        phonePlatforms.addItemListener(this);
        updateDistribution();
        if (settings.getProperty(PROP_PHONE_TABLET_ENABLED) instanceof Boolean) {
            phoneEnabled.setSelected((boolean) settings.getProperty(PROP_PHONE_TABLET_ENABLED));
        }
        if (settings.getProperty(PROP_WEAR_ENABLED) instanceof Boolean) {
            wearEnabled.setSelected((boolean) settings.getProperty(PROP_WEAR_ENABLED));
        }
        if (settings.getProperty(PROP_TV_ENABLED) instanceof Boolean) {
            tvEnabled.setSelected((boolean) settings.getProperty(PROP_TV_ENABLED));
        }

        if (settings.getProperty(PROP_PHONE_TABLET_PLATFORM) instanceof AndroidPlatformInfo) {
            phonePlatforms.setSelectedItem((AndroidPlatformInfo) settings.getProperty(PROP_PHONE_TABLET_PLATFORM));
        }
        if (settings.getProperty(PROP_WEAR_PLATFORM) instanceof AndroidPlatformInfo) {
            wearPlatforms.setSelectedItem((AndroidPlatformInfo) settings.getProperty(PROP_WEAR_PLATFORM));
        }
        if (settings.getProperty(PROP_TV_PLATFORM) instanceof AndroidPlatformInfo) {
            tvPlatforms.setSelectedItem((AndroidPlatformInfo) settings.getProperty(PROP_TV_PLATFORM));
        }
        Object folder_mobile = settings.getProperty(PROP_PHONE_TABLET_FOLDER);
        File projectLocation = (File) settings.getProperty(PROP_PROJECT_DIR);
        if (folder_mobile instanceof String) {
            mobileFolder.setText((String) folder_mobile);
        } else {
            if (projectLocation != null) {
                mobileFolder.setText(projectLocation.getName() + "_mobile");
            }
        }
        Object folder_wear = settings.getProperty(PROP_WEAR_FOLDER);
        if (folder_wear instanceof String) {
            wearFolder.setText((String) folder_wear);
        } else {
            if (projectLocation != null) {
                wearFolder.setText(projectLocation.getName() + "_wear");
            }
        }
        Object folder_tv = settings.getProperty(PROP_TV_FOLDER);
        if (folder_tv instanceof String) {
            tvFolder.setText((String) folder_tv);
        } else {
            if (projectLocation != null) {
                tvFolder.setText(projectLocation.getName() + "_tv");
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        updateDistribution();
        panel.fireChangeEvent();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateTexts(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateTexts(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateTexts(e);
    }

    private void updateTexts(DocumentEvent e) {
        panel.fireChangeEvent(); // Notify that the panel changed
        if (this.mobileFolder.getDocument() == e.getDocument()) {
            firePropertyChange(PROP_PHONE_TABLET_FOLDER, null, this.mobileFolder.getText());
        }
        if (this.wearFolder.getDocument() == e.getDocument()) {
            firePropertyChange(PROP_WEAR_FOLDER, null, this.wearFolder.getText());
        }
        if (this.tvFolder.getDocument() == e.getDocument()) {
            firePropertyChange(PROP_TV_FOLDER, null, this.tvFolder.getText());
        }
    }

    class ComboBoxRenderer extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            AndroidPlatformInfo info = (AndroidPlatformInfo) value;
            int apiLevel = info.getAndroidVersion().getApiLevel();
            label.setText("API " + apiLevel + " : " + SdkVersionInfo.getVersionWithCodename(info.getAndroidVersion()));
            return label;
        }

    }

    void validate(WizardDescriptor d) throws WizardValidationException {
        // nothing to validate
    }

    public static boolean isFilenameValid(String file) {
        if(file.contains("\\")||file.contains(".")||file.contains("<")||file.contains(">")||file.contains(":")
                ||file.contains("\"")||file.contains("/")||file.contains("|")
                || file.contains("?") || file.contains("*") || file.contains(" ")) {
            return false;
        }
        File f = new File(file);
        try {
            return f.getCanonicalFile().getName().equals(file);
        } catch (IOException e) {
            return false;
        }
    }
}
