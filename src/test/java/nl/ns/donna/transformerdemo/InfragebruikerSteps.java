package nl.ns.donna.transformerdemo;

import cucumber.api.Transform;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.Stel;
import nl.ns.donna.transformerdemo.model.InfraGebruiker;
import nl.ns.donna.transformerdemo.transformer.InfraGebruikerTransformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InfragebruikerSteps {

    private Logger log = LogManager.getLogger(InfragebruikerSteps.class);

    private InfraGebruiker infraGebruiker;

    @Stel("^T ik heb een infragebruiker \"([^\"]*)\"")
    public void ik_heb_een_infragebruiker(@Transform(InfraGebruikerTransformer.class) InfraGebruiker infraGebruiker) {
        this.infraGebruiker = infraGebruiker;
    }

    @Stel("^ik heb een infragebruiker \"([^\"]*)\"")
    public void ik_heb_een_infragebruiker(String infraGebruikerString) {
        log.info("InfragebruikerString = " + infraGebruikerString);
        infraGebruiker = InfraGebruiker.geefEnumVoorAfkorting(infraGebruikerString);
    }

    @Dan("^is het deze bekend als \"([^\"]*)\"$")
    public void is_het_deze_bekend_als_NSInternational(String validatieString) {
        assertThat(infraGebruiker.getVolledigeNaam(), is(validatieString));
        log.info("Infragebruiker = " + infraGebruiker.getVolledigeNaam());
    }
}
