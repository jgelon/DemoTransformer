/*
 * Copyright 2016 ProRail & Nederlandse Spoorwegen N.V.
 *
 * Broncode en het daarin voorkomende intellectueel eigendom
 * behoren toe aan ProRail en Nederlandse Spoorwegen N.V.
 * Gebruik en/of publicatie in welke (afgeleide) vorm en wijze dan ook
 * zijn zonder voorafgaande schriftelijke toestemming niet toegestaan.
 *
 * Created 13 apr. 2016
 */
package nl.ns.donna.transformerdemo.transformer;


import cucumber.api.Transformer;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import edu.umd.cs.findbugs.annotations.DefaultAnnotation;
import edu.umd.cs.findbugs.annotations.DefaultAnnotationForMethods;
import edu.umd.cs.findbugs.annotations.NonNull;
import nl.ns.donna.transformerdemo.model.InfraGebruiker;
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
