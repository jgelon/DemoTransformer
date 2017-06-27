package nl.demo.transformers.model;

import nl.donna.generiek.common.dto.Valideer;

import edu.umd.cs.findbugs.annotations.DefaultAnnotation;
import edu.umd.cs.findbugs.annotations.NonNull;

/**
 * Dit zijn de ondersteunde InfraGebruikers in Cucumber
 *
 * @author Jurn van Mieghem
 *
 */
@DefaultAnnotation(NonNull.class)
public enum InfraGebruiker {
    NSR("NSR", "NS-Reizigers"), HSP("HSP", "NS_International"), NSI("NSI", "NS_International");

    private final String afkorting;

    private final String volledigeNaam;

    private InfraGebruiker(String afkorting, String volledigeNaam) {
        this.afkorting = Valideer.notNull(afkorting);
        this.volledigeNaam = Valideer.notNull(volledigeNaam);
    }

    public static InfraGebruiker geefEnumVoorAfkorting(String gegevenAfkorting) {
        for (InfraGebruiker infraGebruiker : InfraGebruiker.values()) {
            if (infraGebruiker.afkorting.equalsIgnoreCase(gegevenAfkorting)) {
                return infraGebruiker;
            }
        }
        throw new IllegalStateException("De afkorting " + gegevenAfkorting + " wordt niet herkend.");
    }

    public static InfraGebruiker geefEnumVoorVolledigeNaam(String gegevenNaam) {
        for (InfraGebruiker infraGebruiker : InfraGebruiker.values()) {
            if (infraGebruiker.volledigeNaam.equalsIgnoreCase(gegevenNaam)) {
                return infraGebruiker;
            }
        }
        throw new IllegalStateException("De volledigeNaam " + gegevenNaam + " wordt niet herkend.");
    }

    public String getVolledigeNaam() {
        return volledigeNaam;
    }
}
