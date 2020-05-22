package com.sidesoft.flopec.budget.businessEvent;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.service.db.DalConnectionProvider;

import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;
import com.sidesoft.flopec.budget.data.SFBBudgetCertificate;

public class BudgetCertAmounts extends EntityPersistenceEventObserver {

  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
		  SFBBudgetCertLine.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }
  
//Proceso que se ejecuta al dar click en nuevo y guardar
  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    		final SFBBudgetCertLine SFBBudgetCertLine = (SFBBudgetCertLine) event.getTargetInstance();
        
    		ReturnQuery(SFBBudgetCertLine); 
    		
    	       // Asignamos los datos en variables de tipo BigDecimal y Long
    		
        	BigDecimal v_commited_value = SFBBudgetCertLine.getCommittedValue();
        	BigDecimal v_executed_value = SFBBudgetCertLine.getExecutedValue();
        	BigDecimal v_certified_value = SFBBudgetCertLine.getCertifiedValue();
        	
            double SumComValue =0;  
            double SumExecValue=0;
            double SumCertValue=0;        	
        	
        	SumComValue=SumComValue + v_commited_value.doubleValue();
        	SumExecValue =SumExecValue + v_executed_value.doubleValue();
        	SumCertValue = SumCertValue + v_certified_value.doubleValue();
        	
        	// Obtenemos el ID de la Cabecera del certificado cuando se crea un nuevo registro en las
        	// lineas del certificado
        	
        	String strCertificateID = SFBBudgetCertLine.getSFBBudgetCertificate().getId().toString();
        	
            //Instancia del Certificado -Cabecera
        	
            SFBBudgetCertificate certificate = OBDal.getInstance().get(SFBBudgetCertificate.class,
            		strCertificateID);        	
            
            //Seteamos/ubicamos los valores en los campos que se desea actualizar
            
        	BigDecimal v_commited_value2 = certificate.getCommittedValue();
        	BigDecimal v_executed_value2 = certificate.getExecutedValue();
        	BigDecimal v_certified_value2 = certificate.getCertifiedValue();
        	
            double SumComValue2 =0;  
            double SumExecValue2=0;
            double SumCertValue2=0; 
            
            SumComValue2 = v_commited_value2.doubleValue() +SumComValue ;
            SumExecValue2 = v_executed_value2.doubleValue() +SumExecValue;
            SumCertValue2 = v_certified_value2.doubleValue() + SumCertValue;

            BigDecimal ComVal = new BigDecimal(SumComValue2);
            BigDecimal ExecVal = new BigDecimal(SumExecValue2);
            BigDecimal CertValue = new BigDecimal(SumCertValue2);
            
            certificate.setCommittedValue(ComVal);
            certificate.setExecutedValue(ExecVal);
            certificate.setCertifiedValue(CertValue);
            
            // Guardamos los valores asignados
            
            OBDal.getInstance().save(certificate);  
  }
  
  //Proceso que se ejecuta al dar click en guardar, una vez editado/actualizado los datos
  public void onUpdate(@Observes EntityUpdateEvent event) throws ServletException{
	    if (!isValidEvent(event)) {
	      return;
	    }
	    
		final SFBBudgetCertLine SFBBudgetCertLine = (SFBBudgetCertLine) event.getTargetInstance();
        
        ReturnQuery(SFBBudgetCertLine);
  } 
  
  public void onDelete(@Observes EntityDeleteEvent event) {
	    if (!isValidEvent(event)) {
	      return;
	    }
		
	    final SFBBudgetCertLine SFBBudgetCertLine = (SFBBudgetCertLine) event.getTargetInstance();
        	    
	    ReturnQuery(SFBBudgetCertLine);

    	BigDecimal v_commited_value = SFBBudgetCertLine.getCommittedValue();
    	BigDecimal v_executed_value = SFBBudgetCertLine.getExecutedValue();
    	BigDecimal v_certified_value = SFBBudgetCertLine.getCertifiedValue();
    	
        double SumComValue =0;  
        double SumExecValue=0;
        double SumCertValue=0;        	

        SumComValue=SumComValue + v_commited_value.doubleValue();
    	SumExecValue =SumExecValue + v_executed_value.doubleValue();
    	SumCertValue = SumCertValue + v_certified_value.doubleValue();
    	// Obtenemos el ID de la Cabecera del certificado cuando se crea un nuevo registro en las
    	// lineas del certificado
    	
    	String strCertificateID = SFBBudgetCertLine.getSFBBudgetCertificate().getId().toString();
    	
        //Instancia del Certificado -Cabecera
    	
        SFBBudgetCertificate certificate = OBDal.getInstance().get(SFBBudgetCertificate.class,
        		strCertificateID);        	
        
        //Seteamos/ubicamos los valores en los campos que se desea actualizar
        
        BigDecimal v_commited_value2 = certificate.getCommittedValue();
        BigDecimal v_executed_value2 = certificate.getExecutedValue();
        BigDecimal v_certified_value2 = certificate.getCertifiedValue();
    	
        double SumComValue2 =0;  
        double SumExecValue2=0;
        double SumCertValue2=0; 
        
        SumComValue2 = v_commited_value2.doubleValue() -SumComValue ;
        SumExecValue2 = v_executed_value2.doubleValue() -SumExecValue;
        SumCertValue2 = v_certified_value2.doubleValue() - SumCertValue;

        BigDecimal ComVal = new BigDecimal(SumComValue2);
        BigDecimal ExecVal = new BigDecimal(SumExecValue2);
        BigDecimal CertValue = new BigDecimal(SumCertValue2);
    	
        certificate.setCommittedValue(ComVal);
        certificate.setExecutedValue(ExecVal);
        certificate.setCertifiedValue(CertValue);
        
        // Guardamos los valores asignados
        
        OBDal.getInstance().save(certificate);  	    
}  

  private void ReturnQuery(SFBBudgetCertLine sFBBudgetCertLine) {
	    @SuppressWarnings("unused")
		ConnectionProvider conn = new DalConnectionProvider(false);
	    //String language = OBContext.getOBContext().getLanguage().getLanguage();
      
	    	String strcertlineID = sFBBudgetCertLine.getId().toString(); //Asignamos el ID de la linea del certificado

	        OBCriteria<SFBBudgetCertLine> BudgetCertLineCritria = OBDal.getInstance().createCriteria(
	        		SFBBudgetCertLine.class); // Instanciamos la tabla de las lineas del certificado
	        
	        BudgetCertLineCritria.add(Restrictions.eq(SFBBudgetCertLine.PROPERTY_ID, strcertlineID)); //Simialr a una clausula [select * from sfb_budget_cert_line{SFBBudgetCertLine}]

	        String strCertificateID = sFBBudgetCertLine.getSFBBudgetCertificate().getId().toString(); //Asigno el ID de la cabecera del certificado
          
          //Inicializamos las variables de tipo long para realizar la suma
          	
	        double SumComValue =0;  
	        double SumExecValue=0;
	        double SumCertValue=0;
	        
	        //Fin Inicializar variables
	        
	        SFBBudgetCertificate BudgetCertificate = sFBBudgetCertLine.getSFBBudgetCertificate();
	        
	        OBCriteria<SFBBudgetCertLine> BudgetCertLinesCriteria = OBDal.getInstance().createCriteria(
	        		SFBBudgetCertLine.class);
	        BudgetCertLinesCriteria.add(Restrictions.eq(SFBBudgetCertLine.PROPERTY_SFBBUDGETCERTIFICATE, BudgetCertificate));
	        
	          List<SFBBudgetCertLine> BudgetCertLinesCriteriaList = BudgetCertLinesCriteria.list(); // Instanciamos como una lista para verificar el numero de registros
	          
	        
	        
	        //Asignamos el numero de registros de tipo entero	        
		    int NumUser2line = BudgetCertLinesCriteriaList.size();
	        
		    if (NumUser2line > 0) {
	        
		    //Creamos una lista/array de las lineas del certificado
		    	
	        for (SFBBudgetCertLine certline : BudgetCertLinesCriteria.list()) {
	            
	        	// Si encontramos asignamos los valores en variables de tipo bidgecimal
	        	
	        	BigDecimal v_commited_value = certline.getCommittedValue();
	        	BigDecimal v_executed_value = certline.getExecutedValue();
	        	BigDecimal v_certified_value = certline.getCertifiedValue(); 
	        	
	        	//Realizamos la suma convirtiendo el valor anterior a tipo Long
	        	
	        	SumComValue=SumComValue + v_commited_value.doubleValue();
	        	SumExecValue =SumExecValue + v_executed_value.doubleValue();
	        	SumCertValue = SumCertValue + v_certified_value.doubleValue();
	        	
	          }

	        //Instancia del Certificado
	        SFBBudgetCertificate certificate = OBDal.getInstance().get(SFBBudgetCertificate.class,
	        		strCertificateID);
	        
	        
	        BigDecimal ComVal = new BigDecimal(SumComValue);
	        BigDecimal ExecVal = new BigDecimal(SumExecValue);
	        BigDecimal CertValue = new BigDecimal(SumCertValue);
	        //seteamos los campos del certificado
	        certificate.setCommittedValue(ComVal);
	        certificate.setExecutedValue(ExecVal);
	        certificate.setCertifiedValue(CertValue);
	        OBDal.getInstance().save(certificate);

	    }
	  }
}

