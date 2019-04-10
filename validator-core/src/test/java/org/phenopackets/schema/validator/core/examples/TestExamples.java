package org.phenopackets.schema.validator.core.examples;import com.google.protobuf.Timestamp;import org.phenopackets.schema.v1.Family;import org.phenopackets.schema.v1.Phenopacket;import org.phenopackets.schema.v1.core.*;/** * This class offers static methods for creating PhenoPacket parts for testing. * * @author Daniel Danis <daniel.danis@jax.org> */public class TestExamples {    public static final OntologyClass MALE = ontologyClass("PATO:0000384", "male");    public static final OntologyClass FEMALE = ontologyClass("PATO:0000383", "female");    public static final OntologyClass CHILDHOOD_ONSET = ontologyClass("HP:0011463", "Childhood onset");    public static final OntologyClass ADULT_ONSET = ontologyClass("HP:0003581", "Adult onset");    public static final OntologyClass MODERATE = ontologyClass("HP:0012826", "Moderate");    public static final OntologyClass HET = ontologyClass("GENO:0000135", "heterozygous");    public static final OntologyClass HOM = ontologyClass("GENO:0000136", "homozygous");    public static final OntologyClass TRIGGERED_BY_EXCITEMENT = ontologyClass("HP:0025227", "Triggered by excitement");    // source https://bioportal.bioontology.org/ontologies/ECO/?p=classes&conceptid=http%3A%2F%2Fpurl.obolibrary.org%2Fobo%2FECO_0000033&jump_to_nav=true    public static final OntologyClass TRACEABLE_AUTHOR_STATEMENT = ontologyClass("ECO:0000033", "author statement supported by traceable reference");    public static final OntologyClass HOMO_SAPIENS = ontologyClass("NCBITaxon:9606", "Homo sapiens");    private TestExamples() {        // private no-op    }    /**     * @return {@link MetaData}     */    public static MetaData makeValidMetadata() {        return MetaData.newBuilder()                .setCreated(Timestamp.newBuilder().setSeconds(1553261206).setNanos(921000000).build()) // 2019-03-22T13:26:46.921Z                .setCreatedBy("Koko the chimp")                .setSubmittedBy("Phenopacket submitter 3000 LE")                .addResources(getHpoResource())                .addResources(getGenoResource())                .addResources(getMondoResource())                .addResources(getNcbiTaxonResource())                .addUpdated(Timestamp.newBuilder().setSeconds(1553261433).setNanos(260000000).build()) // 2019-03-22T13:30:33.026Z                .addUpdated(Timestamp.newBuilder().setSeconds(1553261489).setNanos(586000000).build()) // 2019-03-22T13:31:29.586Z                .addExternalReferences(getExternalReferenceExample())                .build();    }    public static ExternalReference getExternalReferenceExample() {        return ExternalReference.newBuilder()                .setId("PMID:87654321")                .setDescription("The most curious case report")                .build();    }    public static Resource getGenoResource() {        return Resource.newBuilder()                .setId("geno")                .setName("Genotype Ontology")                .setNamespacePrefix("GENO")                .setIriPrefix("http://purl.obolibrary.org/obo/GENO_")                .setUrl("http://purl.obolibrary.org/obo/geno.owl")                .setVersion("19-03-2018")                .build();    }    public static Resource getPatoResource() {        return Resource.newBuilder()                .setId("pato")                .setName("Phenotype And Trait Ontology")                .setNamespacePrefix("PATO")                .setIriPrefix("http://purl.obolibrary.org/obo/PATO_")                .setUrl("http://purl.obolibrary.org/obo/pato.owl")                .setVersion("2018-03-28")                .build();    }    public static Resource getMondoResource() {        return Resource.newBuilder()                .setId("mondo")                .setName("Monarch Disease Ontology")                .setNamespacePrefix("MONDO")                .setIriPrefix("http://purl.obolibrary.org/obo/MONDO_")                .setUrl("http://purl.obolibrary.org/obo/mondo.owl")                .setVersion("2018-03-28")                .build();    }    public static Resource getHpoResource() {        return Resource.newBuilder()                .setId("hp")                .setName("Human Phenotype Ontology")                .setNamespacePrefix("HP")                .setIriPrefix("http://purl.obolibrary.org/obo/HP_")                .setUrl("http://purl.obolibrary.org/obo/hp.owl")                .setVersion("2018-03-08")                .build();    }    public static Resource getMpResource() {        return Resource.newBuilder()                .setId("mp")                .setName("Mammalian Phenotype Ontology")                .setNamespacePrefix("MP")                .setIriPrefix("http://purl.obolibrary.org/obo/MP_")                .setUrl("http://purl.obolibrary.org/obo/mp.owl")                .setVersion("2019-03-08")                .build();    }    public static Resource getNcbiTaxonResource() {        return Resource.newBuilder()                .setId("ncbitaxon")                .setName("NCBI taxonomy database")                .setNamespacePrefix("NCBITaxon")                .setIriPrefix("http://purl.obolibrary.org/obo/NCBITaxon_")                .setUrl("http://purl.obolibrary.org/obo/ncbitaxon.owl")                .setVersion("2019-03-08")                .build();    }    /**     * @return {@link Phenotype} of spherocytosis (<code>HP:0004444</code>) with childhood onset (<code>HP:0011463</code>).     */    public static Phenotype spherocytosisWithChildhoodOnset() {        return Phenotype.newBuilder()                .setType(ontologyClass("HP:0004444", "Spherocytosis"))                .setClassOfOnset(CHILDHOOD_ONSET)                .build();    }    /**     * @return {@link Phenotype} of poikilocytosis (<code>HP:0004447</code>) with childhood onset (<code>HP:0011463</code>).     */    public static Phenotype poikilocytosisWithChildhoodOnset() {        return Phenotype.newBuilder()                .setType(ontologyClass("HP:0004447", "Poikilocytosis"))                .setClassOfOnset(CHILDHOOD_ONSET)                .build();    }    /**     * @return {@link Phenotype} of anemia (<code>HP:0001903</code>) with childhood onset (<code>HP:0011463</code>).     */    public static Phenotype anemiaWithChildhoodOnset() {        return Phenotype.newBuilder()                .setType(ontologyClass("HP:0001903", "Anemia"))                .setClassOfOnset(CHILDHOOD_ONSET)                .build();    }    /**     * @return {@link Phenotype} of hepatosplenomegaly (<code>HP:0001433</code>) with adult onset (<code>HP:0003581</code>).     */    public static Phenotype hepatosplenomegalyWithAdultOnset() {        return Phenotype.newBuilder()                .setType(ontologyClass("HP:0001433", "Hepatosplenomegaly"))                .setClassOfOnset(ADULT_ONSET)                .build();    }    /**     * @return {@link Phenotype} of increased CSF lactate     */    public static Phenotype moderatelyIncreasedCSFLactate() {        return Phenotype.newBuilder()                .setDescription("Observation of increased CSF lactate")                .setType(ontologyClass("HP:0002490", "Increased CSF lactate"))                .setAbsent(false)                .setSeverity(MODERATE)                .addModifiers(TRIGGERED_BY_EXCITEMENT)                .addEvidence(getEvidenceInstance())                .build();    }    /**     *     * @return {@link Evidence} of <em>author statement supported by traceable reference (ECO:0000033)</em> pointing to     * mock paper <em>PMID:87654321 - The most curious case report</em>     */    public static Evidence getEvidenceInstance() {        return Evidence.newBuilder().setEvidenceCode(TRACEABLE_AUTHOR_STATEMENT).setReference(getExternalReferenceExample()).build();    }    /**     * @return Phenotype of Peripheral axonal degeneration with childhood onset. An obsolete term id     * <code>HP:0006876</code> is used instead of the current term id <code>HP:0000764</code>     */    public static Phenotype obsoletePeripheralAxonalDegenerationWithChildhoodOnset() {        return Phenotype.newBuilder()                .setType(ontologyClass("HP:0006876", "Peripheral axonal degeneration"))                .setClassOfOnset(CHILDHOOD_ONSET)                .build();    }    /**     * convenience function for creating an OntologyClass object.     */    public static OntologyClass ontologyClass(String id, String label) {        return OntologyClass.newBuilder()                .setId(id)                .setLabel(label)                .build();    }    /**     * Example phenopacket -- we still need to develop this for testing.     */    public static Phenopacket getJohnnyPhenopacket() {        return Phenopacket.newBuilder()                .setSubject(getIndividualJohnny())                .addPhenotypes(hepatosplenomegalyWithAdultOnset())                .addPhenotypes(spherocytosisWithChildhoodOnset())                .addGenes(getSPTA1Gene())                .addVariants(getSPTA1Variant(HOM))                .addDiseases(getHereditarySpherocytosis())                .setMetaData(makeValidMetadata())                .build();    }    private static Disease getHereditarySpherocytosis() {        return Disease.newBuilder()                .setTerm(ontologyClass("MONDO:0000094", "Spherocytosis"))                .setAgeOfOnset(Age.newBuilder().setAge("P5Y2M").build())                .build();    }    private static Gene getSPTA1Gene() {        return Gene.newBuilder()                .setId("HGNC:6708")                .setSymbol("SPTA1")                .build();    }    public static Phenopacket getDonnaPhenopacket() {        return Phenopacket.newBuilder()                .setSubject(getIndividualDonna())                .addPhenotypes(moderatelyIncreasedCSFLactate())                .addGenes(getSURF1Gene())                .addVariants(getSURF1Variant(HOM))                .addDiseases(getLeighDisease())                .setMetaData(makeValidMetadata())                .build();    }    private static Disease getLeighDisease() {        return Disease.newBuilder()                .setTerm(ontologyClass("MONDO:0018859", "Leigh disease"))                .setAgeOfOnset(Age.newBuilder().setAge("P0Y6M").build())                .build();    }    private static Gene getSURF1Gene() {        return Gene.newBuilder()                .setId("HGNC:6834")                .setSymbol("SURF1")                .build();    }    /**     * @return {@link Variant} representing SNP <a href="https://www.ncbi.nlm.nih.gov/snp/rs373551988">rs373551988</a>     * in <em>SURF1</em> gene.     */    public static Variant getSURF1Variant(OntologyClass genotype) {        return Variant.newBuilder()                .setVcfAllele(VcfAllele.newBuilder()                        .setId("rs373551988")                        .setChr("chr9")                        .setPos(133353855)                        .setRef("G")                        .setAlt("A")                        .setInfo("AF=0.13")                        .build())                .setZygosity(genotype)                .build();    }    /**     * @return {@link Variant} representing SNP <a href="https://www.ncbi.nlm.nih.gov/snp/rs121918635">rs121918635</a>     * in <em>SPTA1</em> gene.     */    private static Variant getSPTA1Variant(OntologyClass genotype) {        return Variant.newBuilder()                .setVcfAllele(VcfAllele.newBuilder()                        .setId("rs121918635")                        .setChr("chr1")                        .setPos(158672135)                        .setRef("T")                        .setAlt("G")                        .setInfo("AF=0.02")                        .build())                .setZygosity(genotype)                .build();    }    public static Individual getIndividualJohnny() {        return Individual.newBuilder()                .setSex(Sex.MALE)                .setId("Johnny")                .setAgeAtCollection(Age.newBuilder().setAge("P27Y3M").build())                .setTaxonomy(HOMO_SAPIENS)                .build();    }    public static Individual getIndividualDonna() {        return Individual.newBuilder()                .setSex(Sex.FEMALE)                .setId("Donna")                .setAgeRangeAtCollection(AgeRange.newBuilder()                        .setStart(Age.newBuilder().setAge("P20Y").build())                        .setEnd(Age.newBuilder().setAge("P30Y").build())                        .build())                .setTaxonomy(HOMO_SAPIENS)                .build();    }    public static Family getSingleSampleFamilyForJohnny() {        return Family.newBuilder()                .setProband(getJohnnyPhenopacket())                .setPedigree(Pedigree.newBuilder()                        .addPersons(Pedigree.Person.newBuilder()                                .setFamilyId("FAM001")                                .setIndividualId(getJohnnyPhenopacket().getSubject().getId())                                .setPaternalId("0")                                .setMaternalId("0")                                .setSex(Sex.MALE)                                .setAffectedStatus(Pedigree.Person.AffectedStatus.AFFECTED)                                .build())                        .build())                .build();    }}