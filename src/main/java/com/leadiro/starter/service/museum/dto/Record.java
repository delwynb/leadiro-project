package com.leadiro.starter.service.museum.dto;

import lombok.Data;

import java.util.List;

@Data
public class Record {
  private String id;
  private Object taxonomy;
  private String qualifierRank;
  private String qualifier;
  private String dateIdentified;
  private String identifiedBy;
  private String typeStatus;
  private String recordType;
  private String displayTitle;
  private String dateModified;
  private String category;
  private String discipline;
  private String type;
  private String registrationNumber;
  private String objectName;
  private String objectSummary;
  private String physicalDescription;
  private String inscription;
  private String significance;
  private String shape;
  private String modelScale;
  private String references;
  private String acquisitionInformation;
  private String acknowledgement;

  private String museumLocation;
  private String archeologyContextNumber;
  private String archeologySite;
  private String archeologyDescription;
  private String archeologyDistinguishingMarks;
  private String archeologyActivity;
  private String archeologySpecificActivity;
  private String archeologyDecoration;
  private String archeologyPattern;
  private String archeologyMoulding;
  private String archeologyColour;
  private String archeologyPlacement;
  private String archeologyForm;
  private String archeologyShape;
  private String archeologyManufactureName;
  private String archeologyManufactureDate;
  private String archeologyTechnique;
  private String archeologyProvenance;
  private String numismaticsDenomination;
  private String numismaticsDateIssued;
  private String numismaticsSeries;
  private String numismaticsMaterial;
  private String numismaticsAxis;
  private String numismaticsEdgeDescription;
  private String numismaticsObverseDescription;
  private String numismaticsReverseDescription;
  private String philatelyColour;
  private String philatelyDenomination;
  private String philatelyImprint;
  private String philatelyIssue;
  private String philatelyDateIssued;
  private String philatelyForm;
  private String philatelyOverprint;
  private String philatelyGibbonsNumber;
  private String isdFormat;
  private String isdLanguage;
  private String isdDescriptionOfContent;
  private String isdPeopleDepicted;
  private String audioVisualRecordingDetails;
  private List<Object> audioVisualContentSummaries;
  private String tradeLiteratureNumberofPages;
  private String tradeLiteraturePageSizeFormat;
  private String tradeLiteratureCoverTitle;
  private String tradeLiteraturePrimarySubject;
  private String tradeLiteraturePublicationDate;
  private String tradeLiteratureIllustrationTypes;
  private String tradeLiteraturePrintingTypes;
  private List<Object> tradeLiteraturePublicationTypes;
  private String tradeLiteraturePrimaryRole;
  private String tradeLiteraturePrimaryName;
  private String indigenousCulturesMedium;
  private String indigenousCulturesDescription;
  private String indigenousCulturesLocalName;
  private String indigenousCulturesPhotographer;
  private String indigenousCulturesAuthor;
  private String indigenousCulturesIllustrator;
  private String indigenousCulturesMaker;
  private String indigenousCulturesDate;
  private String indigenousCulturesCollector;
  private String indigenousCulturesDateCollected;
  private String indigenousCulturesIndividualsIdentified;
  private String indigenousCulturesTitle;
  private String indigenousCulturesSheets;
  private String indigenousCulturesPages;
  private String indigenousCulturesLetterTo;
  private String indigenousCulturesLetterFrom;
  private String artworkMedium;
  private String artworkTechnique;
  private String artworkSupport;
  private String artworkPlateNumber;
  private String artworkDrawingNumber;
  private String artworkState;
  private String artworkPublisher;
  private String artworkPrimaryInscriptions;
  private String artworkSecondaryInscriptions;
  private String artworkTertiaryInscriptions;
  private List<Object> indigenousCulturesLocalities;
  private List<Object> indigenousCulturesCulturalGroups;

  private List<Object> collectionNames;
  private List<Object> collectionAreas;
  private List<Object> classifications;
  private List<Object> keywords;
  private List<Object> bibliographies;
  private List<Object> modelNames;
  private List<Object> brands;
  private List<Object> relatedItemIds;
  private List<Object> relatedSpecimenIds;
  private List<Object> relatedArticleIds;
  private List<Object> relatedSpeciesIds;

  private License license;
  private List<Associations> associations;
  private List<Dimensions> dimensions;
  private List<Media> media;

  @Data
  static class Media {
    private String id;
    private String dateModified;
    private String caption;
    private String credit;
    private String rightsStatement;
    private List<String> creators;
    private List<String> sources;
    private String type;
    private String alternativeText;
    private MediaItem large;
    private MediaItem medium;
    private MediaItem small;
    private MediaItem thumbnail;
    private License license;

    @Data
    static class MediaItem {
      private String width;
      private String height;
      private String uri;
      private String size;
    }
  }

  @Data
  static class License {
    private String name;
    private String shortName;
    private String uri;
  }

  @Data
  static class Associations {
    private String type;
    private String name;
    private String date;
    private String comments;
    private String streetAddress;
    private String locality;
    private String region;
    private String state;
    private String country;
  }

  @Data
  static class Dimensions {
    private String configuration;
    private String dimensions;
    private String comments;
  }
}
