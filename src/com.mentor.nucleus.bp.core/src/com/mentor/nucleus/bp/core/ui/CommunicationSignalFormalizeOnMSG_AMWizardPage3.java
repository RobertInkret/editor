package com.mentor.nucleus.bp.core.ui;
//====================================================================
//
// File:    CommunicationSignalFormalizeOnMSG_AMWizardPage3.java
//
// WARNING: Do not edit this generated file
// Generated by arc/page.inc
//
// (c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.
//
//====================================================================
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;

import com.mentor.nucleus.bp.core.*;
import com.mentor.nucleus.bp.core.common.ClassQueryInterface_c;

import java.util.ArrayList;
import java.util.List;

public class CommunicationSignalFormalizeOnMSG_AMWizardPage3
		extends
			PtWizardPage implements Listener {
	public static final String copyright = "(c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.";

	IWorkbench workbench;
	IStructuredSelection selection;

	// widgets on this page (public for unit tests)

	// cache for user choices

	/**
	 * Constructors for CommunicationSignalFormalizeOnMSG_AMWizardPage3.
	 */
	public CommunicationSignalFormalizeOnMSG_AMWizardPage3() {
		super("");
		init();
	}

	public CommunicationSignalFormalizeOnMSG_AMWizardPage3(String name) {
		super(name);
		init();
	}

	private void init() {
		setTitle("Formalize");
		setDescription("Choose the message to send");
	}

	public void onPageEntry() {
		Ooaofooa modelRoot = Selection
				.getModelRoot((StructuredSelection) ((CommunicationSignalFormalizeOnMSG_AMWizard) getWizard())
						.getSelection());

		// cache for previous user selections
		InterfaceSignal_c v_Signal = ((CommunicationSignalFormalizeOnMSG_AMWizard) getWizard()).v_Signal;

		// cache for context
		AsynchronousMessage_c v_asyncMessage = ((CommunicationSignalFormalizeOnMSG_AMWizard) getWizard()).v_asyncMessage;
		ComponentParticipant_c v_cop = ((CommunicationSignalFormalizeOnMSG_AMWizard) getWizard()).v_cop;

		if (((v_asyncMessage != null))) {

			if (((v_cop != null))) {

				Message_c v_message = Message_c
						.getOneMSG_MOnR1018(v_asyncMessage);

				InteractionParticipant_c v_participant = InteractionParticipant_c
						.getOneSQ_POnR930(v_cop);

				Component_c v_comp = Component_c.getOneC_COnR955(v_cop);

				if (((v_comp != null))) {

					Interface_c[] v_interfaces = Interface_c
							.getManyC_IsOnR4012(InterfaceReference_c
									.getManyC_IRsOnR4016(Port_c
											.getManyC_POsOnR4010(v_comp)));

					if (((v_Signal != null))) {

					}

				}

			}

		}

	}

	public void createControl(Composite parent) {
		// create the composite to hold the widgets   
		GridData gd = null;
		Composite composite = new Composite(parent, SWT.NULL);

		// create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		int ncol = 5;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		// set the composite as the control for this page
		setControl(composite);
		onPageEntry(); // Initialize the ui widget contents
		addListeners();
	}

	private void addListeners() {
	}

	/**
	 * @see Listener#handleEvent(Event)
	 */
	public void handleEvent(Event event) {
		getWizard().getContainer().updateButtons();
	}

	public boolean isPageComplete() {
		boolean isPageComplete = true;
		return isPageComplete;
	}

	public IWizardPage getNextPage() {
		PtWizardPage page = (PtWizardPage) getWizard().getNextPage(this);
		page.onPageEntry();
		return page;
	}

	/**
	 * @see IWizardPage#canFlipToNextPage()
	 */
	public boolean canFlipToNextPage() {
		if ((PtWizardPage) getWizard().getNextPage(this) == null)
			return false;
		return true;
	}

}