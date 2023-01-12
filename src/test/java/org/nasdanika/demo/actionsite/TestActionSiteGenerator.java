package org.nasdanika.demo.actionsite;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.junit.jupiter.api.Test;
import org.nasdanika.html.model.app.gen.ActionSiteGenerator;

public class TestActionSiteGenerator {
		
	@Test
	public void testActionSiteGenerator() throws IOException, DiagnosticException {
		ActionSiteGenerator actionSiteGenerator = new ActionSiteGenerator();
		
		String rootActionResource = "model/actions.yml";
		URI rootActionURI = URI.createFileURI(new File(rootActionResource).getAbsolutePath());
		
		String pageTemplateResource = "model/page-template.yml";
		URI pageTemplateURI = URI.createFileURI(new File(pageTemplateResource).getAbsolutePath());
		
		Map<String, Collection<String>> errors = actionSiteGenerator.generate(
				rootActionURI, 
				pageTemplateURI, 
				"https://nasdanika.org/demo-action-site", 
				new File("docs"), 
				new File("target/action-site"), 
				false);
		
		System.out.println(errors);
	}
	
}
