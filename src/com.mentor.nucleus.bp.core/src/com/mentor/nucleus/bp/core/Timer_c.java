package com.mentor.nucleus.bp.core;
//====================================================================
//
// File:      com.mentor.nucleus.bp.core.Timer_c.java
//
// WARNING: Do not edit this generated file
// Generated by ../MC-Java/java.arc, $Revision: 1.111 $
//
// (c) Copyright 2005-2014 by Mentor Graphics Corp.  All rights reserved.
//
//====================================================================

// No special imports
import java.util.*;
import java.lang.reflect.*;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import com.mentor.nucleus.bp.core.util.PersistenceUtil;
import org.eclipse.core.runtime.NullProgressMonitor;
import com.mentor.nucleus.bp.core.ui.marker.UmlProblem;
import java.util.concurrent.locks.ReentrantLock;
import com.mentor.nucleus.bp.core.common.*;
abstract class EV_TIMER extends genericEvent_c {
	public abstract int getEvtcode();
}

public class Timer_c extends NonRootModelElement
		implements
			IAdaptable,
			Cloneable {
	// Public Constructors
	public Timer_c(ModelRoot modelRoot, java.util.UUID p_m_timer_id,
			int p_m_delay, boolean p_m_running, boolean p_m_recurring,
			java.util.UUID p_m_event_id, String p_m_label, long p_m_expiration) {
		super(modelRoot);
		//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
		m_timer_id = IdAssigner.preprocessUUID(p_m_timer_id);
		//extract 28 bit value only            
		m_timer_idLongBased = 0xfffffff & p_m_timer_id
				.getLeastSignificantBits();
		m_delay = p_m_delay;
		m_running = p_m_running;
		m_recurring = p_m_recurring;
		//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
		m_event_id = IdAssigner.preprocessUUID(p_m_event_id);
		m_label = p_m_label;
		m_expiration = p_m_expiration;

		setUniqueId(m_timer_id);
		Object[] key = {m_timer_id};
		addInstanceToMap(key);
	}
	static public Timer_c createProxy(ModelRoot modelRoot,
			java.util.UUID p_m_timer_id, int p_m_delay, boolean p_m_running,
			boolean p_m_recurring, java.util.UUID p_m_event_id,
			String p_m_label, long p_m_expiration, String p_contentPath,
			IPath p_localPath) {
		ModelRoot resolvedModelRoot = ModelRoot.findModelRoot(modelRoot,
				p_contentPath, p_localPath);
		// if a model root was not resolved it is most likely
		// due to a missing file of the proxy, defualt back to
		// the original model root
		if (resolvedModelRoot != null)
			modelRoot = resolvedModelRoot;
		InstanceList instances = modelRoot.getInstanceList(Timer_c.class);
		Timer_c new_inst = null;
		synchronized (instances) {
			Object[] key = {p_m_timer_id};
			new_inst = (Timer_c) instances.get(key);
		}
		String contentPath = PersistenceUtil.resolveRelativePath(p_localPath,
				new Path(p_contentPath));
		if (modelRoot.isNewCompareRoot()) {
			// for comparisons we do not want to change
			// the content path
			contentPath = p_contentPath;
		}
		if (new_inst != null && !modelRoot.isCompareRoot()) {
			PersistableModelComponent pmc = new_inst.getPersistableComponent();
			if (pmc == null) {
				// dangling reference, redo this instance
				new_inst.batchUnrelate();
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				new_inst.m_timer_id = IdAssigner.preprocessUUID(p_m_timer_id);
				//extract 28 bit value only            
				new_inst.m_timer_idLongBased = 0xfffffff & p_m_timer_id
						.getLeastSignificantBits();
				new_inst.m_delay = p_m_delay;
				new_inst.m_running = p_m_running;
				new_inst.m_recurring = p_m_recurring;
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				new_inst.m_event_id = IdAssigner.preprocessUUID(p_m_event_id);
				new_inst.m_label = p_m_label;
				new_inst.m_expiration = p_m_expiration;

			}
		}
		if (new_inst == null) {
			// there is no instance matching the id, create a proxy
			// if the resource doesn't exist then this will be a dangling reference
			new_inst = new Timer_c(modelRoot, p_m_timer_id, p_m_delay,
					p_m_running, p_m_recurring, p_m_event_id, p_m_label,
					p_m_expiration);
			new_inst.m_contentPath = contentPath;
		}
		return new_inst;
	}

	static public Timer_c resolveInstance(ModelRoot modelRoot,
			java.util.UUID p_m_timer_id, int p_m_delay, boolean p_m_running,
			boolean p_m_recurring, java.util.UUID p_m_event_id,
			String p_m_label, long p_m_expiration) {
		InstanceList instances = modelRoot.getInstanceList(Timer_c.class);
		Timer_c source = null;
		synchronized (instances) {
			Object[] key = {p_m_timer_id};
			source = (Timer_c) instances.get(key);
			if (source != null && !modelRoot.isCompareRoot()) {
				source.convertFromProxy();
				source.batchUnrelate();
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				source.m_timer_id = IdAssigner.preprocessUUID(p_m_timer_id);
				//extract 28 bit value only            
				source.m_timer_idLongBased = 0xfffffff & p_m_timer_id
						.getLeastSignificantBits();
				source.m_delay = p_m_delay;
				source.m_running = p_m_running;
				source.m_recurring = p_m_recurring;
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				source.m_event_id = IdAssigner.preprocessUUID(p_m_event_id);
				source.m_label = p_m_label;
				source.m_expiration = p_m_expiration;

				return source;
			}
		}
		// there is no instance matching the id
		Timer_c new_inst = new Timer_c(modelRoot, p_m_timer_id, p_m_delay,
				p_m_running, p_m_recurring, p_m_event_id, p_m_label,
				p_m_expiration);
		return new_inst;
	}
	public Timer_c(ModelRoot modelRoot) {
		super(modelRoot);
		m_timer_id = idAssigner.createUUID();
		m_event_id = IdAssigner.NULL_UUID;
		m_label = "";
		setUniqueId(m_timer_id);
		Object[] key = {m_timer_id};
		addInstanceToMap(key);
	}

	public Object getInstanceKey() {
		Object[] key = {m_timer_id};
		return key;
	}

	public boolean setInstanceKey(UUID p_newKey) {

		boolean changed = false;
		// round p1
		// round p2
		// round p3
		// round p5
		if (m_timer_id != p_newKey) {

			m_timer_id = p_newKey;
			changed = true;
		}
		return changed;
	}

	public boolean equals(Object elem) {
		if (!(elem instanceof Timer_c)) {
			return false;
		}
		// check that the model-roots are the same
		if (((NonRootModelElement) elem).getModelRoot() != getModelRoot()) {
			return false;
		}

		return identityEquals(elem);
	}

	public boolean identityEquals(Object elem) {
		if (!(elem instanceof Timer_c)) {
			return false;
		}

		Timer_c me = (Timer_c) elem;
		// don't allow an empty id-value to produce a false positive result;
		// in this case, use whether the two instances are actually the same 
		// one in memory, instead
		if ((IdAssigner.NULL_UUID.equals(getTimer_id()) || IdAssigner.NULL_UUID
				.equals(((Timer_c) elem).getTimer_id())) && this != elem) {
			return false;
		}
		if (!getTimer_id().equals(((Timer_c) elem).getTimer_id()))
			return false;
		return true;
	}

	public boolean cachedIdentityEquals(Object elem) {
		if (!(elem instanceof Timer_c)) {
			return false;
		}

		Timer_c me = (Timer_c) elem;
		if (!getTimer_id().equals(((Timer_c) elem).getTimer_id()))
			return false;
		return true;
	}

	// Attributes
	private java.util.UUID m_timer_id;
	private long m_timer_idLongBased;
	private int m_delay;
	private boolean m_running;
	private boolean m_recurring;
	private java.util.UUID m_event_id;
	private String m_label;
	private long m_expiration;

	// declare association references from this class

	// referring navigation

	PendingEvent_c ProvidesDelayedDeliveryOfPendingEvent;
	public void relateAcrossR2940To(PendingEvent_c target) {
		relateAcrossR2940To(target, true);
	}
	public void relateAcrossR2940To(PendingEvent_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (target == ProvidesDelayedDeliveryOfPendingEvent)
			return; // already related

		if (ProvidesDelayedDeliveryOfPendingEvent != target) {

			Object oldKey = getInstanceKey();

			if (ProvidesDelayedDeliveryOfPendingEvent != null) {

				ProvidesDelayedDeliveryOfPendingEvent
						.clearBackPointerR2940To(this);

				if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == true) { //$NON-NLS-1$
					Ooaofooa.log
							.println(
									ILogger.CONSISTENCY,
									"Timer_c.relateAcrossR2940To(PendingEvent_c target)",
									"Relate performed across R2940 from Timer to Pending Event without unrelate of prior instance.");
				}
			}

			ProvidesDelayedDeliveryOfPendingEvent = target;
			m_event_id = target.getEvent_id();
			updateInstanceKey(oldKey, getInstanceKey());
			target.setBackPointerR2940To(this);
			target.addRef();
			if (notifyChanges) {
				RelationshipChangeModelDelta change = new RelationshipChangeModelDelta(
						Modeleventnotification_c.DELTA_ELEMENT_RELATED, this,
						target, "2940", "");
				Ooaofooa.getDefaultInstance().fireModelElementRelationChanged(
						change);
			}
		}
	}
	public void unrelateAcrossR2940From(PendingEvent_c target) {
		unrelateAcrossR2940From(target, true);
	}
	public void unrelateAcrossR2940From(PendingEvent_c target,
			boolean notifyChanges) {
		if (target == null)
			return;

		if (ProvidesDelayedDeliveryOfPendingEvent == null)
			return; // already unrelated

		if (target != ProvidesDelayedDeliveryOfPendingEvent) {
			Exception e = new Exception();
			e.fillInStackTrace();
			CorePlugin.logError(
					"Tried to unrelate from non-related instance across R2940",
					e);
			return;
		}

		if (target != null) {
			target.clearBackPointerR2940To(this);
		}

		if (ProvidesDelayedDeliveryOfPendingEvent != null) {

			m_event_id = ProvidesDelayedDeliveryOfPendingEvent.getEvent_id();
			ProvidesDelayedDeliveryOfPendingEvent = null;
			target.removeRef();
			if (notifyChanges) {
				RelationshipChangeModelDelta change = new RelationshipChangeModelDelta(
						Modeleventnotification_c.DELTA_ELEMENT_UNRELATED, this,
						target, "2940", "");
				Ooaofooa.getDefaultInstance().fireModelElementRelationChanged(
						change);
			}
		}
	}

	public static Timer_c getOneI_TIMOnR2940(PendingEvent_c[] targets) {
		return getOneI_TIMOnR2940(targets, null);
	}

	public static Timer_c getOneI_TIMOnR2940(PendingEvent_c[] targets,
			ClassQueryInterface_c test) {
		Timer_c ret_val = null;
		if (targets != null) {
			for (int i = 0; i < targets.length && ret_val == null; ++i) {
				ret_val = getOneI_TIMOnR2940(targets[i], test);
			}
		}

		return ret_val;
	}

	public static Timer_c getOneI_TIMOnR2940(PendingEvent_c target) {
		return getOneI_TIMOnR2940(target, null);
	}

	public static Timer_c getOneI_TIMOnR2940(PendingEvent_c target,
			boolean loadComponent) {
		return getOneI_TIMOnR2940(target.getModelRoot(), target, null,
				loadComponent);
	}

	public static Timer_c getOneI_TIMOnR2940(PendingEvent_c target,
			ClassQueryInterface_c test) {
		if (target != null) {
			return getOneI_TIMOnR2940(target.getModelRoot(), target, test);
		}
		return null;
	}

	public static Timer_c getOneI_TIMOnR2940(ModelRoot modelRoot,
			PendingEvent_c target, ClassQueryInterface_c test) {
		return getOneI_TIMOnR2940(modelRoot, target, test, true);
	}

	public static Timer_c getOneI_TIMOnR2940(ModelRoot modelRoot,
			PendingEvent_c target, ClassQueryInterface_c test,
			boolean loadComponent) {
		return find_getOneI_TIMOnR2940(modelRoot, target, test);
	}
	private static Timer_c find_getOneI_TIMOnR2940(ModelRoot modelRoot,
			PendingEvent_c target, ClassQueryInterface_c test) {
		if (target != null) {
			Timer_c source = (Timer_c) target.backPointer_DeliveredByTimerDeliveredBy_R2940;
			if (source != null && (test == null || test.evaluate(source))) {
				return source;
			}
		}
		// not found
		return null;
	}

	public static Timer_c[] getManyI_TIMsOnR2940(PendingEvent_c[] targets) {
		return getManyI_TIMsOnR2940(targets, null);
	}
	public static Timer_c[] getManyI_TIMsOnR2940(PendingEvent_c[] targets,
			boolean loadComponent) {
		return getManyI_TIMsOnR2940(targets, null, loadComponent);
	}
	public static Timer_c[] getManyI_TIMsOnR2940(PendingEvent_c[] targets,
			ClassQueryInterface_c test) {
		return getManyI_TIMsOnR2940(targets, test, true);
	}

	public static Timer_c[] getManyI_TIMsOnR2940(PendingEvent_c[] targets,
			ClassQueryInterface_c test, boolean loadComponent) {

		if (targets == null || targets.length == 0 || targets[0] == null)
			return new Timer_c[0];

		ModelRoot modelRoot = targets[0].getModelRoot();

		InstanceList instances = modelRoot.getInstanceList(Timer_c.class);

		Vector matches = new Vector();
		for (int i = 0; i < targets.length; i++) {
			Timer_c source = (Timer_c) targets[i].backPointer_DeliveredByTimerDeliveredBy_R2940;
			if (source != null && (test == null || test.evaluate(source))) {
				matches.add(source);
			}
		}
		if (matches.size() > 0) {
			Timer_c[] ret_set = new Timer_c[matches.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new Timer_c[0];
		}
	}

	public static Timer_c[] getManyI_TIMsOnR2940(PendingEvent_c target) {
		if (target != null) {
			PendingEvent_c[] targetArray = new PendingEvent_c[1];
			targetArray[0] = target;
			return getManyI_TIMsOnR2940(targetArray);
		} else {
			Timer_c[] result = new Timer_c[0];
			return result;
		}
	}

	public static Timer_c[] getManyI_TIMsOnR2940(PendingEvent_c target,
			boolean loadComponent) {
		if (target != null) {
			PendingEvent_c[] targetArray = new PendingEvent_c[1];
			targetArray[0] = target;
			return getManyI_TIMsOnR2940(targetArray, loadComponent);
		} else {
			Timer_c[] result = new Timer_c[0];
			return result;
		}
	}

	public void batchRelate(ModelRoot modelRoot, boolean notifyChanges,
			boolean searchAllRoots) {
		batchRelate(modelRoot, false, notifyChanges, searchAllRoots);
	}

	public void batchRelate(ModelRoot modelRoot, boolean relateProxies,
			boolean notifyChanges, boolean searchAllRoots) {
		InstanceList instances = null;
		ModelRoot baseRoot = modelRoot;

		if (ProvidesDelayedDeliveryOfPendingEvent == null) {
			// R2940
			PendingEvent_c relInst40163 = (PendingEvent_c) baseRoot
					.getInstanceList(PendingEvent_c.class).get(
							new Object[]{m_event_id});
			// if there was no local element, check for any global elements
			// failing that proceed to check other model roots
			if (relInst40163 == null) {
				relInst40163 = (PendingEvent_c) Ooaofooa.getDefaultInstance()
						.getInstanceList(PendingEvent_c.class)
						.get(new Object[]{m_event_id});
			}
			if (relInst40163 == null && searchAllRoots
					&& !baseRoot.isCompareRoot()) {
				Ooaofooa[] roots = Ooaofooa.getInstances();
				for (int i = 0; i < roots.length; i++) {
					if (roots[i].isCompareRoot()) {
						// never use elements from any compare root
						continue;
					}
					relInst40163 = (PendingEvent_c) roots[i].getInstanceList(
							PendingEvent_c.class).get(new Object[]{m_event_id});
					if (relInst40163 != null)
						break;
				}
			}
			//synchronized
			if (relInst40163 != null) {
				if (relateProxies || !isProxy()
						|| (inSameComponent(this, relInst40163) && !isProxy())) {
					relInst40163.relateAcrossR2940To(this, notifyChanges);
				}
			}
		}

	}
	public void batchUnrelate(boolean notifyChanges) {
		NonRootModelElement inst = null;
		// R2940
		// I_EVI
		inst = ProvidesDelayedDeliveryOfPendingEvent;
		unrelateAcrossR2940From(ProvidesDelayedDeliveryOfPendingEvent,
				notifyChanges);
		if (inst != null) {
			inst.removeRef();
		}
	}
	public static void batchRelateAll(ModelRoot modelRoot,
			boolean notifyChanges, boolean searchAllRoots) {
		batchRelateAll(modelRoot, notifyChanges, searchAllRoots, false);
	}
	public static void batchRelateAll(ModelRoot modelRoot, boolean notifyChanges, boolean searchAllRoots, boolean relateProxies)
  {
	InstanceList instances = modelRoot.getInstanceList(Timer_c.class);
    synchronized(instances) {
        Iterator<NonRootModelElement> cursor = instances.iterator() ;
    	while (cursor.hasNext())
	    {
            final Timer_c inst = (Timer_c)cursor.next() ;
	        inst.batchRelate(modelRoot, relateProxies, notifyChanges, searchAllRoots );
	    }
	}
  }
	public static void clearInstances(ModelRoot modelRoot) {
		InstanceList instances = modelRoot.getInstanceList(Timer_c.class);
		synchronized (instances) {
			for (int i = instances.size() - 1; i >= 0; i--) {
				((NonRootModelElement) instances.get(i)).delete_unchecked();
			}

		}
	}

	public static Timer_c TimerInstance(ModelRoot modelRoot,
			ClassQueryInterface_c test, boolean loadComponent) {
		Timer_c result = findTimerInstance(modelRoot, test, loadComponent);
		return result;
	}
	private static Timer_c findTimerInstance(ModelRoot modelRoot,
			ClassQueryInterface_c test, boolean loadComponent) {
		InstanceList instances = modelRoot.getInstanceList(Timer_c.class);
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				Timer_c x = (Timer_c) instances.get(i);
				if (test == null || test.evaluate(x)) {
					return x;
				}
			}
		}
		return null;
	}
	public static Timer_c TimerInstance(ModelRoot modelRoot,
			ClassQueryInterface_c test) {
		return TimerInstance(modelRoot, test, true);
	}

	public static Timer_c TimerInstance(ModelRoot modelRoot) {
		return TimerInstance(modelRoot, null, true);
	}

	public static Timer_c[] TimerInstances(ModelRoot modelRoot,
			ClassQueryInterface_c test, boolean loadComponent) {
		InstanceList instances = modelRoot.getInstanceList(Timer_c.class);
		Vector matches = new Vector();
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				Timer_c x = (Timer_c) instances.get(i);
				if (test == null || test.evaluate(x)) {
					matches.add(x);
				}
			}
			if (matches.size() > 0) {
				Timer_c[] ret_set = new Timer_c[matches.size()];
				matches.copyInto(ret_set);
				return ret_set;
			} else {
				return new Timer_c[0];
			}
		}
	}
	public static Timer_c[] TimerInstances(ModelRoot modelRoot,
			ClassQueryInterface_c test) {
		return TimerInstances(modelRoot, test, true);
	}
	public static Timer_c[] TimerInstances(ModelRoot modelRoot) {
		return TimerInstances(modelRoot, null, true);
	}

	public boolean delete() {
		boolean result = super.delete();
		boolean delete_error = false;
		String errorMsg = "The following relationships were not torn down by the Timer.dispose call: ";
		PendingEvent_c testR2940Inst = PendingEvent_c.getOneI_EVIOnR2940(this,
				false);

		if (testR2940Inst != null) {
			delete_error = true;
			errorMsg = errorMsg + "2940 ";
		}
		if (delete_error == true) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log.println(ILogger.DELETE, "Timer", errorMsg);
			} else {
				Exception e = new Exception();
				e.fillInStackTrace();
				CorePlugin.logError(errorMsg, e);
			}
		}
		return result;
	}

	/**
	 * Assigns IDs to instances of this class.
	 */
	private static IdAssigner idAssigner = new IdAssigner();

	/**
	 * See field.
	 */
	public IdAssigner getIdAssigner() {
		return idAssigner;
	}

	/**
	 * See field.
	 */
	public static IdAssigner getIdAssigner_() {
		return idAssigner;
	}
	// end declare instance pool

	// declare attribute accessors
	public boolean isUUID(String attributeName) {
		if (attributeName.equals("timer_id")) {
			return true;
		}
		if (attributeName.equals("event_id")) {
			return true;
		}
		return false;
	}
	// declare attribute accessors
	public long getTimer_idLongBased() {
		if (m_timer_idLongBased == 0
				&& !IdAssigner.NULL_UUID.equals(m_timer_id)) {
			return 0xfffffff & m_timer_id.getLeastSignificantBits();
		}
		return m_timer_idLongBased;
	}
	public java.util.UUID getTimer_id() {
		return m_timer_id;
	}

	public void setTimer_id(java.util.UUID newValue) {
		m_timer_id = IdAssigner.preprocessUUID(newValue);
	}
	public int getDelay() {
		return m_delay;
	}

	public void setDelay(int newValue) {
		if (m_delay == newValue) {
			return;
		}
		AttributeChangeModelDelta change = new AttributeChangeModelDelta(
				Modeleventnotification_c.DELTA_ATTRIBUTE_CHANGE, this, "Delay",
				new Integer(m_delay), new Integer(newValue), false);

		m_delay = newValue;
		Ooaofooa.getDefaultInstance().fireModelElementAttributeChanged(change);
	}
	public boolean getRunning() {
		return m_running;
	}

	public void setRunning(boolean newValue) {
		if (m_running == newValue) {
			return;
		}
		AttributeChangeModelDelta change = new AttributeChangeModelDelta(
				Modeleventnotification_c.DELTA_ATTRIBUTE_CHANGE, this,
				"Running", new Boolean(m_running), new Boolean(newValue), false);

		m_running = newValue;
		Ooaofooa.getDefaultInstance().fireModelElementAttributeChanged(change);
	}
	public boolean getRecurring() {
		return m_recurring;
	}

	public void setRecurring(boolean newValue) {
		if (m_recurring == newValue) {
			return;
		}
		AttributeChangeModelDelta change = new AttributeChangeModelDelta(
				Modeleventnotification_c.DELTA_ATTRIBUTE_CHANGE, this,
				"Recurring", new Boolean(m_recurring), new Boolean(newValue),
				false);

		m_recurring = newValue;
		Ooaofooa.getDefaultInstance().fireModelElementAttributeChanged(change);
	}
	public long getEvent_idLongBased() {
		if (ProvidesDelayedDeliveryOfPendingEvent != null) {
			return ProvidesDelayedDeliveryOfPendingEvent.getEvent_idLongBased();
		}
		return 0;
	}
	public java.util.UUID getEvent_id() {
		if (ProvidesDelayedDeliveryOfPendingEvent != null) {
			return ProvidesDelayedDeliveryOfPendingEvent.getEvent_id();
		}
		return IdAssigner.NULL_UUID;
	}

	public java.util.UUID getEvent_idCachedValue() {
		if (!IdAssigner.NULL_UUID.equals(m_event_id))
			return m_event_id;
		else
			return getEvent_id();
	}

	public void setEvent_id(java.util.UUID newValue) {
		if (newValue != null) {
			if (newValue.equals(m_event_id)) {
				return;
			}
		} else if (m_event_id != null) {
			if (m_event_id.equals(newValue)) {
				return;
			}
		} else {
			return;
		}
		AttributeChangeModelDelta change = new AttributeChangeModelDelta(
				Modeleventnotification_c.DELTA_ATTRIBUTE_CHANGE, this,
				"Event_id", m_event_id, newValue, false);
		m_event_id = IdAssigner.preprocessUUID(newValue);
		Ooaofooa.getDefaultInstance().fireModelElementAttributeChanged(change);
	}
	public String getLabel() {
		ModelRoot modelRoot = getModelRoot();
		int v_timeLeft = Util_c.Difflongstoint(getExpiration(), Currenttime());

		String v_result = Gd_c.Int_to_string(v_timeLeft) + " uS remaining";

		PendingEvent_c v_evt = PendingEvent_c.getOneI_EVIOnR2940(this);

		if ((v_timeLeft < 0 || (v_evt == null))) {

			v_result = "not running";

		}

		else {

			v_result = v_result + ", " + v_evt.getLabel();

		}

		return v_result;

	}

	public long getExpiration() {
		return m_expiration;
	}

	public void setExpiration(long newValue) {
		if (m_expiration == newValue) {
			return;
		}
		AttributeChangeModelDelta change = new AttributeChangeModelDelta(
				Modeleventnotification_c.DELTA_ATTRIBUTE_CHANGE, this,
				"Expiration", new Long(m_expiration), new Long(newValue), false);

		m_expiration = newValue;
		Ooaofooa.getDefaultInstance().fireModelElementAttributeChanged(change);
	}
	// end declare accessors
	public static void checkClassConsistency(ModelRoot modelRoot) {
		Ooaofooa.log.println(ILogger.OPERATION, "Timer", //$NON-NLS-1$
				" Operation entered: Timer::checkClassConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return;
		}
		Timer_c[] objs = Timer_c.TimerInstances(modelRoot, null, false);

		for (int i = 0; i < objs.length; i++) {
			objs[i].checkConsistency();
		}
	}
	public boolean checkConsistency() {
		Ooaofooa.log.println(ILogger.OPERATION, "Timer", //$NON-NLS-1$
				" Operation entered: Timer::checkConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return true;
		}
		ModelRoot modelRoot = getModelRoot();
		boolean retval = true;
		class Timer_c_test40165_c implements ClassQueryInterface_c {
			Timer_c_test40165_c(java.util.UUID p40166) {
				m_p40166 = p40166;
			}
			private java.util.UUID m_p40166;
			public boolean evaluate(Object candidate) {
				Timer_c selected = (Timer_c) candidate;
				boolean retval = false;
				retval = (selected.getTimer_id().equals(m_p40166));
				return retval;
			}
		}

		Timer_c[] objs40164 = Timer_c.TimerInstances(modelRoot,
				new Timer_c_test40165_c(getTimer_id()));

		if (((objs40164.length) == 0)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Timer", //$NON-NLS-1$
								"Consistency: Object: Timer: Cardinality of an identifier is zero. " //$NON-NLS-1$
										+ "Actual Value: " + Integer.toString(objs40164.length)); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin.logError(
						"Consistency: Object: Timer: Cardinality of an identifier is zero. " //$NON-NLS-1$ 
								+ "Actual Value: " //$NON-NLS-1$
								+ Integer.toString(objs40164.length), e);
			}
			retval = false;

		}

		if (((objs40164.length) > 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log.println(ILogger.CONSISTENCY, "Timer", //$NON-NLS-1$
						"Consistency: Object: Timer: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$
								+ "Actual Value: " //$NON-NLS-1$ 
								+ Integer.toString(objs40164.length)
								+ " Timer_ID: " + "Not Printable"); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin.logError(
						"Consistency: Object: Timer: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$ 
								+ "Actual Value: " //$NON-NLS-1$
								+ Integer.toString(objs40164.length)
								+ " Timer_ID: " + "Not Printable", e); //$NON-NLS-1$
			}
			retval = false;

		}

		// Timer is a referring class in association: rel.Numb = 2940
		// The participating class is: Pending Event
		class PendingEvent_c_test40170_c implements ClassQueryInterface_c {
			PendingEvent_c_test40170_c(java.util.UUID p40171) {
				m_p40171 = p40171;
			}
			private java.util.UUID m_p40171;
			public boolean evaluate(Object candidate) {
				PendingEvent_c selected = (PendingEvent_c) candidate;
				boolean retval = false;
				retval = (selected.getEvent_id().equals(m_p40171));
				return retval;
			}
		}

		PendingEvent_c[] objs40169 = PendingEvent_c.PendingEventInstances(
				modelRoot, new PendingEvent_c_test40170_c(getEvent_id()));

		if (((objs40169.length) > 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Timer", //$NON-NLS-1$
								"Consistency: Object: Timer: Association: 2940: Cardinality of a participant is greater than 1. " //$NON-NLS-1$
										+ "Actual Value: " //$NON-NLS-1$ 
										+ Integer.toString(objs40169.length)
										+ " Event_ID: " + "Not Printable"); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Timer: Association: 2940: Cardinality of a participant is greater than 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs40169.length)
										+ " Event_ID: " + "Not Printable", e); //$NON-NLS-1$
			}
			retval = false;

		}

		return retval;
	}

	// declare transform functions
	public void Tick() {
		Ooaofooa.log.println(ILogger.OPERATION, "Timer",
				" Operation entered: Timer::Tick");
		final ModelRoot modelRoot = getModelRoot();

	} // End tick
	public void Fire() {
		Ooaofooa.log.println(ILogger.OPERATION, "Timer",
				" Operation entered: Timer::Fire");
		final ModelRoot modelRoot = getModelRoot();
		PendingEvent_c v_evt = PendingEvent_c.getOneI_EVIOnR2940(this);

		Removetimer();

		if (((v_evt != null))) {

			if ((getRecurring() == true)) {

				setExpiration(Util_c.Addinttolong(getDelay(), Currenttime()));

				java.util.UUID v_evt_ID = v_evt.Clone();

				PendingEvent_c v_newEvt = (PendingEvent_c) modelRoot
						.getInstanceList(PendingEvent_c.class).getGlobal(null,
								v_evt_ID);

				this.unrelateAcrossR2940From(v_evt);

				this.relateAcrossR2940To(v_newEvt);

				ComponentInstance_c v_comptInst = ComponentInstance_c
						.getOneI_EXEOnR2964(v_evt);

				Inserttimer(v_comptInst.getExecution_engine_id());

			}

			if (v_evt != null) {
				v_evt.Fire();
			} else {
				Throwable t = new Throwable();
				t.fillInStackTrace();
				CorePlugin
						.logError(
								"Attempted to call an operation on a null instance.",
								t);
			}

		}

		if ((getRecurring() == false)) {

			boolean v_discard = Dispose();

		}

	} // End fire
	public boolean Dispose() {
		Ooaofooa.log.println(ILogger.OPERATION, "Timer",
				" Operation entered: Timer::Dispose");
		final ModelRoot modelRoot = getModelRoot();
		boolean v_result = false;

		return v_result;

	} // End dispose
	public void Set(final int p_Delay) {
		Ooaofooa.log.println(ILogger.OPERATION, "Timer",
				" Operation entered: Timer::Set");
		final ModelRoot modelRoot = getModelRoot();
		setRunning(false);

		setRecurring(false);

		setDelay(p_Delay);

		setExpiration(Util_c.Addinttolong(getDelay(), Currenttime()));

	} // End set
	public long Currenttime() {
		Ooaofooa.log.println(ILogger.OPERATION, "Timer",
				" Operation entered: Timer::Currenttime");
		return lib.TIM.getCurrentTime();
	} // End currentTime
	public void Removetimer() {
		Ooaofooa.log.println(ILogger.OPERATION, "Timer",
				" Operation entered: Timer::Removetimer");
		lib.TIM.removeTimer(this);
	} // End removeTimer
	public void Inserttimer(final java.util.UUID p_Componentinstanceid) {
		Ooaofooa.log.println(ILogger.OPERATION, "Timer",
				" Operation entered: Timer::Inserttimer");
		ModelRoot modelRoot = getModelRoot();
		ComponentInstance_c ee = (ComponentInstance_c) modelRoot
				.getInstanceList(ComponentInstance_c.class).getGlobal(
						p_Componentinstanceid);
		lib.TIM.insertTimer(this, ee);

	} // End insertTimer

	// end transform functions

	public Object getAdapter(Class adapter) {
		Object superAdapter = super.getAdapter(adapter);
		if (superAdapter != null) {
			return superAdapter;
		}
		return null;
	}
} // end Timer