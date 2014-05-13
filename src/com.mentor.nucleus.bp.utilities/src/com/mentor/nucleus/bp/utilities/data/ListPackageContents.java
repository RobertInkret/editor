//========================================================================
//
//File:      com.mentor.nucleus.bp.utilities/src/com/mentor/nucleus/bp/utilities/actions/CheckModelIntegrity.java
//
//Copyright 2005-2014 Mentor Graphics Corporation. All rights reserved.
//
//========================================================================
// Licensed under the Apache License, Version 2.0 (the "License"); you may not 
// use this file except in compliance with the License.  You may obtain a copy 
// of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the 
// License for the specific language governing permissions and limitations under
// the License.
//======================================================================== 
package com.mentor.nucleus.bp.utilities.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;

import com.mentor.nucleus.bp.core.Component_c;
import com.mentor.nucleus.bp.core.IntegrityIssue_c;
import com.mentor.nucleus.bp.core.IntegrityManager_c;
import com.mentor.nucleus.bp.core.Ooaofooa;
import com.mentor.nucleus.bp.core.Package_c;
import com.mentor.nucleus.bp.core.PackageableElement_c;
import com.mentor.nucleus.bp.core.SystemModel_c;
import com.mentor.nucleus.bp.core.common.IntegrityChecker;
import com.mentor.nucleus.bp.core.common.NonRootModelElement;
import com.mentor.nucleus.bp.core.util.UIUtil;
import com.mentor.nucleus.bp.core.util.UIUtil.BPMessageTypes;

public class ListPackageContents implements IActionDelegate {

	private ISelection selection;

	@Override
	public void run(IAction action) {
		
		String msg = "no shit sherlock";
		
		if (selection instanceof IStructuredSelection){
			IStructuredSelection ss = (IStructuredSelection) selection;
			for (Iterator<?> iterator = ss.iterator(); iterator.hasNext();){
				Object selected = iterator.next();
				if(selected instanceof Package_c){
					Package_c pkg = (Package_c) selected;
					//get all packages
					Package_c[] pkgs= Package_c.getManyEP_PKGsOnR8001(PackageableElement_c.getManyPE_PEsOnR8000(pkg));
					for(int i=0;i<pkgs.length;i++){
						msg += "\nPackage: " + pkgs[i].getName();
					}
					//get all components
					Component_c[] comps = Component_c.getManyC_CsOnR8001(PackageableElement_c.getManyPE_PEsOnR8000(pkg));
					for(int i=0;i<comps.length;i++){
						msg += "\nComponents: " + comps[i].getName();
					}
				}
			}
		}
		
		
		
		if(! msg.isEmpty()){
			UIUtil.openScrollableTextDialog(PlatformUI.getWorkbench()
					.getDisplay().getActiveShell(), false,
					"This is a list of package contents",
					msg,
					"Packages and components inside package:", null, null,
					false);
		}
		
		/*
		UUID managerId = UUID.randomUUID();
		IntegrityManager_c manager = new IntegrityManager_c(
				Ooaofooa.getDefaultInstance(), managerId, null, null);
		List<IntegrityIssue_c> issues = new ArrayList<IntegrityIssue_c>();
		IStructuredSelection ss = (IStructuredSelection) selection;
		for (Iterator<?> iterator = ss.iterator(); iterator.hasNext();) {
			NonRootModelElement element = (NonRootModelElement) iterator.next();
			issues.addAll(Arrays.asList(IntegrityChecker
					.runIntegrityCheck(element, manager)));
		}
		if (!issues.isEmpty()) {
			UIUtil.openScrollableTextDialog(PlatformUI.getWorkbench()
					.getDisplay().getActiveShell(), false,
					"Model Integrity Issues",
					IntegrityChecker.createReportForIssues(issues
							.toArray(new IntegrityIssue_c[issues.size()])),
					"The following integrity issues were found.", null, null,
					false);
		} else {
			UIUtil.openMessageDialog(PlatformUI.getWorkbench().getDisplay()
					.getActiveShell(), "Model Integrity Issues", null,
					IntegrityChecker
							.createReportForIssues(new IntegrityIssue_c[0]),
					BPMessageTypes.INFORMATION, new String[] { "OK" }, 0);
		}
		SystemModel_c system = SystemModel_c.getOneS_SYSOnR1301(manager);
		if(system != null) {
			system.unrelateAcrossR1301From(manager);
		}
		IntegrityIssue_c[] relatedIssues = IntegrityIssue_c.getManyMI_IIsOnR1300(manager);
		for(IntegrityIssue_c issue : relatedIssues) {
			issue.Dispose();
		}
		manager.delete();	*/	
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// cache the selection
		this.selection = selection;
	}

}
