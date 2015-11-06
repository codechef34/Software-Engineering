package jena_programs;
import com.hp.hpl.jena.rdf.model.*;


public class jena_Homework{
	public static void main(String[] args){
	Model m=ModelFactory.createDefaultModel();
        Model m1=ModelFactory.createDefaultModel();
        Model m2=ModelFactory.createDefaultModel();
	String NS="http://myhomework.com/";
	Resource r=m.createResource(NS+"vincent_donofrio");
        Resource r1=m1.createResource(NS+"vincent_donofrio");
        Resource r2=m2.createResource(NS+"Chris_North");
        
        Property p0=m.createProperty(NS+"Has_a_Name");
	Property p=m.createProperty(NS+"starred_in");
        Property p1=m.createProperty(NS+"is-a");
        Property p2=m.createProperty(NS+"released_in");
        Property p3=m.createProperty(NS+"Similar_plot_as");
        Property p4=m.createProperty(NS+"is-a");
        Property p5=m.createProperty(NS+"released_in");
        
        Property p6=m1.createProperty(NS+"Has_a_Name");
	Property p7=m1.createProperty(NS+"starred_in");
        
        Property p8=m1.createProperty(NS+"is-a");
	Property p9=m2.createProperty(NS+"starred_in");
        Property p10=m2.createProperty(NS+"is-a");
        
        
	r.addProperty(p5,NS+"1999").addProperty(p4,NS+"movie").addProperty(p3,NS+"the_matrix").addProperty(p2,NS+"1999").addProperty(p1,NS+"movie").addProperty(p,NS+"the thirteenth floor").addProperty(p0,NS+"Vincent_Donofrio");
        
        
        r1.addProperty(p8,NS+"tvshow").addProperty(p7,NS+"law&&order").addProperty(p6,NS+"Vincent_Donofrio");
        r2.addProperty(p10,NS+"tv show").addProperty(p9,NS+"sex and city").addProperty(p9,NS+"law&&order");
        
        //Model model = m1.union(m2);
         m.write( System.out, "RDF/XML-ABBREV" );
        m1.write( System.out, "RDF/XML-ABBREV" );
        m2.write( System.out, "RDF/XML-ABBREV" );
         
}
}