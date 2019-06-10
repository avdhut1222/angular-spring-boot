import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {TopRoutingModule} from './top-routing.module';
import {TopHomeComponent} from './top-home/top-home.component';
import {AgGridModule} from 'ag-grid-angular';
import {UtilsModule} from '../utils-module/utils.module';
import {FormsModule} from '@angular/forms';
import {ConnectionSearchFormComponent} from './connection-design-search/components/connection-search-form/connection-search-form.component';
import {ConnectionSearchResultsComponent} from './connection-design-search/components/connection-search-results/connection-search-results.component';
import {CircuitDesignDetailsComponent} from './connection-design-search/components/circuit-design-details/circuit-design-details.component';
import {CircuitDetailsComponent} from './connection-design-search/components/circuit-design-details/circuit-details/circuit-details.component';
import {AdministrativeSectionComponent} from './connection-design-search/components/circuit-design-details/administrative-section/administrative-section.component';
import {DesignSectionComponent} from './connection-design-search/components/circuit-design-details/design-section/design-section.component';
import {EuTerminationComponent} from './connection-design-search/components/circuit-design-details/eu-termination/eu-termination.component';
import {NotesSectionComponent} from './connection-design-search/components/circuit-design-details/notes-section/notes-section.component';
import {DesignLinesComponent} from './connection-design-search/components/circuit-design-details/design-lines/design-lines.component';
import {ConnectionDesignService} from './connection-design-search/service/connection-design.service.';
import {PsrLinkRendererComponent} from './psr-criteria-search/components/search-results/psr-link-renderer/psr-link-renderer.component';
import {PsrSearchComponent} from './psr-criteria-search/components/psr-search/psr-search.component';
import {SearchResultsComponent} from './psr-criteria-search/components/search-results/search-results.component';
import {PsrDetailsComponent} from './psr-criteria-search/components/psr-details/psr-details.component';
import {OrderDetailComponent} from './psr-criteria-search/components/psr-details/order-detail/order-detail.component';
import {PsrUserDetailComponent} from './psr-criteria-search/components/psr-details/psr-user-detail/psr-user-detail.component';
import {ContactsComponent} from './psr-criteria-search/components/psr-details/contacts/contacts.component';
import {ServiceLocationDetailsComponent} from './psr-criteria-search/components/psr-details/service-location-details/service-location-details.component';
import {PsrSearchService} from './psr-criteria-search/service/psr-search.service';
import {ConnectionDesignDetailComponent} from './connection-design-search/components/circuit-design-details/connection-design-detail/connection-design-detail.component';
import {CircuitIdLinkRendererComponent} from './connection-design-search/components/connection-search-results/circuit-id-link-renderer/circuit-id-link-renderer.component';
import {CircuitHierarchyLinkRendererComponent} from './connection-design-search/components/circuit-design-details/circuit-hierarchy-link-renderer/circuit-hierarchy-link-renderer.component';
import {CircuitDetailComponent} from './psr-criteria-search/components/psr-details/circuit-detail/circuit-detail.component';
import {TrunkGroupComponent} from './psr-criteria-search/components/psr-details/trunk-group/trunk-group.component';
import {PicInformationComponent} from './psr-criteria-search/components/psr-details/pic-information/pic-information.component';
import {TnFeaturesComponent} from './psr-criteria-search/components/psr-details/tn-features/tn-features.component';
import {HuntGroupComponent} from './psr-criteria-search/components/psr-details/hunt-group/hunt-group.component';
import {ChildSrInformationComponent} from './psr-criteria-search/components/psr-details/child-sr-information/child-sr-information.component';
import {NotesInformationComponent} from './psr-criteria-search/components/psr-details/notes-information/notes-information.component';
import {SrHierarchyComponent} from './psr-criteria-search/components/psr-details/sr-hierarchy/sr-hierarchy.component';
import {CircuitXrefSectionComponent} from './connection-design-search/components/circuit-design-details/circuit-xref-section/circuit-xref-section.component';
import {ConnectionHierarchySearchComponent} from "./connection-hierarchy-search/components/connection-hierarchy-search/connection-hierarchy-search.component";
import {ConnectionHierarchyService} from "./connection-hierarchy-search/service/connection-hierarchy.service";
import { ConnectionHierarchySearchResultsComponent } from './connection-hierarchy-search/components/connection-hierarchy-search-results/connection-hierarchy-search-results.component';
import { ConnectionHierarchyNodeComponent } from './connection-hierarchy-search/components/connection-hierarchy-search-results/connection-hierarchy-node/connection-hierarchy-node.component';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        TopRoutingModule,
        AgGridModule.withComponents([
            PsrLinkRendererComponent,
            CircuitIdLinkRendererComponent,
            CircuitHierarchyLinkRendererComponent
        ]),
        UtilsModule
    ],
    declarations: [
        TopHomeComponent,
        PsrSearchComponent,
        SearchResultsComponent,
        PsrDetailsComponent,
        OrderDetailComponent,
        PsrUserDetailComponent,
        ContactsComponent,
        ServiceLocationDetailsComponent,
        PsrLinkRendererComponent,
        ConnectionSearchFormComponent,
        ConnectionSearchResultsComponent,
        CircuitDesignDetailsComponent,
        CircuitDetailsComponent,
        AdministrativeSectionComponent,
        DesignSectionComponent,
        EuTerminationComponent,
        NotesSectionComponent,
        DesignLinesComponent,
        ConnectionDesignDetailComponent,
        CircuitIdLinkRendererComponent,
        CircuitHierarchyLinkRendererComponent,
        CircuitDetailComponent,
        TrunkGroupComponent,
        PicInformationComponent,
        TnFeaturesComponent,
        HuntGroupComponent,
        NotesInformationComponent,
        ChildSrInformationComponent,
        SrHierarchyComponent,
        CircuitXrefSectionComponent,
        ConnectionHierarchySearchComponent,
        ConnectionHierarchySearchResultsComponent,
        ConnectionHierarchyNodeComponent
    ],
    providers: [
        PsrSearchService,
        ConnectionDesignService,
        ConnectionHierarchyService
    ]
})
export class TopModule {
}
