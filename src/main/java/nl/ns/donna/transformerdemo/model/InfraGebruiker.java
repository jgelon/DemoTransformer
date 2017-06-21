/*
 * Copyright 2016 ProRail & Nederlandse Spoorwegen N.V.
 *
 * Broncode en het daarin voorkomende intellectueel eigendom
 * behoren toe aan ProRail en Nederlandse Spoorwegen N.V.
 * Gebruik en/of publicatie in welke (afgeleide) vorm en wijze dan ook
 * zijn zonder voorafgaande schriftelijke toestemming niet toegestaan.
 *
 * Created 14 apr. 2016
 */
package nl.ns.donna.transformerdemo.model;

import nl.donna.generiek.common.dto.Valideer;

import edu.umd.cs.findbugs.annotations.DefaultAnnotation;
import edu.umd.cs.findbugs.annotations.NonNull;

/**
 * Dit zijn de ondersteunde InfraGebruikers in Cucumber: {@link InfraGebruiker#NSR}, {@link InfraGebruiker#HSP}, {@link InfraGebruiker#NSI}
 *
 * @author xavier.wolfs
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
