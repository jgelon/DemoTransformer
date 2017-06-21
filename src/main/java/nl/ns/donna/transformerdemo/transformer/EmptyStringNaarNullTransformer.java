/*
 * Copyright 2016 ProRail & Nederlandse Spoorwegen N.V.
 *
 * Broncode en het daarin voorkomende intellectueel eigendom
 * behoren toe aan ProRail en Nederlandse Spoorwegen N.V.
 * Gebruik en/of publicatie in welke (afgeleide) vorm en wijze dan ook
 * zijn zonder voorafgaande schriftelijke toestemming niet toegestaan.
 *
 * Created 24 mrt. 2016
 */
package nl.ns.donna.transformerdemo.transformer;

import cucumber.api.Transformer;
import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.DefaultAnnotation;
import edu.umd.cs.findbugs.annotations.NonNull;
import org.apache.commons.lang3.StringUtils;

/**
 * Transformer die een <code>null</code>-waarde teruggeeft op het moment dat een lege {@link String} wordt aangeboden door cucumber. Dit wordt gedaan,
 * zodat andere transformers ten alle tijden gebruik kunnen maken van een gevulde String. Verder is het hierdoor mogelijk om gegevens die niet persé
 * nodig zijn weg te laten.
 *
 * @author xavier.wolfs
 *
 */
@DefaultAnnotation(NonNull.class)
public abstract class EmptyStringNaarNullTransformer<T> extends Transformer<T> {

    protected EmptyStringNaarNullTransformer() {
        super();
    }

    /**
     * Transformeert een {@link String} volgens dezelfde regels als {@link #transform(String)}. Het enige verschil is dat de gegeven String
     * gegarandeerd gevuld is.
     */
    protected abstract T transformeerGevuldeString(String teConverteren);

    @Override
    @CheckForNull
    public final T transform(String teConverteren) {
        if (StringUtils.isEmpty(teConverteren)) {
            return null;
        }

        return transformeerGevuldeString(teConverteren);
    }
}
