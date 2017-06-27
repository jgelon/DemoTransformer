package nl.demo.transformers.transformer;


import cucumber.api.Transformer;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import edu.umd.cs.findbugs.annotations.DefaultAnnotation;
import edu.umd.cs.findbugs.annotations.DefaultAnnotationForMethods;
import edu.umd.cs.findbugs.annotations.NonNull;
import nl.demo.transformers.model.InfraGebruiker;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Jurn van Mieghem
 *
 */
@DefaultAnnotation(NonNull.class)
@DefaultAnnotationForMethods(CheckReturnValue.class)
public class InfraGebruikerTransformer extends Transformer<InfraGebruiker> {

    /** Een correcte infragebruiker naam bestaat uit een enkel woord. Verder moet dit woord voorkomen als afkorting in {@link InfraGebruiker}. */
    public static final String INFRA_GEBRUIKER = "[A-z]+";

    public static final InfraGebruiker STANDAARD_INFRAGEBRUIKER = InfraGebruiker.NSR;

    public InfraGebruikerTransformer() {
        super();
    }

    @Override
    public InfraGebruiker transform(String teConverteren) {
        if (StringUtils.isEmpty(teConverteren)) {
            return STANDAARD_INFRAGEBRUIKER;
        }
        return InfraGebruiker.geefEnumVoorAfkorting(teConverteren);
    }

}
