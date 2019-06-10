import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TopHomeComponent} from './top-home/top-home.component';
import {ConnectionSearchFormComponent} from './connection-design-search/components/connection-search-form/connection-search-form.component';
import {PsrSearchComponent} from './psr-criteria-search/components/psr-search/psr-search.component';
import {SearchResultsComponent} from './psr-criteria-search/components/search-results/search-results.component';
import {PsrDetailsComponent} from './psr-criteria-search/components/psr-details/psr-details.component';
import {OrderDetailComponent} from './psr-criteria-search/components/psr-details/order-detail/order-detail.component';
import {PsrUserDetailComponent} from './psr-criteria-search/components/psr-details/psr-user-detail/psr-user-detail.component';
import {ContactsComponent} from './psr-criteria-search/components/psr-details/contacts/contacts.component';
import {ServiceLocationDetailsComponent} from './psr-criteria-search/components/psr-details/service-location-details/service-location-details.component';
import {ConnectionSearchResultsComponent} from './connection-design-search/components/connection-search-results/connection-search-results.component';
import {CircuitDesignDetailsComponent} from './connection-design-search/components/circuit-design-details/circuit-design-details.component';
import {ConnectionDesignDetailComponent} from './connection-design-search/components/circuit-design-details/connection-design-detail/connection-design-detail.component';
import {CircuitDetailsComponent} from './connection-design-search/components/circuit-design-details/circuit-details/circuit-details.component';
import {AdministrativeSectionComponent} from './connection-design-search/components/circuit-design-details/administrative-section/administrative-section.component';
import {DesignLinesComponent} from './connection-design-search/components/circuit-design-details/design-lines/design-lines.component';
import {DesignSectionComponent} from './connection-design-search/components/circuit-design-details/design-section/design-section.component';
import {EuTerminationComponent} from './connection-design-search/components/circuit-design-details/eu-termination/eu-termination.component';
import {NotesSectionComponent} from './connection-design-search/components/circuit-design-details/notes-section/notes-section.component';
import {CircuitDetailComponent} from './psr-criteria-search/components/psr-details/circuit-detail/circuit-detail.component';
import {TrunkGroupComponent} from './psr-criteria-search/components/psr-details/trunk-group/trunk-group.component';
import {PicInformationComponent} from './psr-criteria-search/components/psr-details/pic-information/pic-information.component';
import {TnFeaturesComponent} from './psr-criteria-search/components/psr-details/tn-features/tn-features.component';
import {HuntGroupComponent} from './psr-criteria-search/components/psr-details/hunt-group/hunt-group.component';
import {NotesInformationComponent} from './psr-criteria-search/components/psr-details/notes-information/notes-information.component';
import {ChildSrInformationComponent} from './psr-criteria-search/components/psr-details/child-sr-information/child-sr-information.component';
import {SrHierarchyComponent} from "./psr-criteria-search/components/psr-details/sr-hierarchy/sr-hierarchy.component";
import {CircuitXrefSectionComponent} from "./connection-design-search/components/circuit-design-details/circuit-xref-section/circuit-xref-section.component";
import {ConnectionHierarchySearchComponent} from "./connection-hierarchy-search/components/connection-hierarchy-search/connection-hierarchy-search.component";
import {ConnectionHierarchySearchResultsComponent} from "./connection-hierarchy-search/components/connection-hierarchy-search-results/connection-hierarchy-search-results.component";

const routes: Routes = [
    {
        path: '',
        component: TopHomeComponent
    },
    {
        path: 'psr-search',
        component: PsrSearchComponent
    },
    {
        path: 'psr-search-results',
        component: SearchResultsComponent
    },
    {
        path: 'psr-details/:docNum',
        component: PsrDetailsComponent,
        children: [
            {
                path: '',
                pathMatch: 'full',
                redirectTo: 'order-details'
            },
            {
                path: 'order-details',
                component: OrderDetailComponent
            },
            {
                path: 'user-detail',
                component: PsrUserDetailComponent
            },
            {
                path: 'contacts',
                component: ContactsComponent
            },
            {
                path: 'service-location',
                component: ServiceLocationDetailsComponent
            },
            {
                path: 'circuit-detail',
                component: CircuitDetailComponent
            },
            {
                path: 'trunk-group',
                component: TrunkGroupComponent
            },
            {
                path: 'pic-information',
                component: PicInformationComponent
            },
            {
                path: 'tn-features',
                component: TnFeaturesComponent
            },
            {
                path: 'hunt-groups',
                component: HuntGroupComponent
            },
            {
                path: 'notes-information',
                component: NotesInformationComponent
            },
            {
                path: 'child-sr-info',
                component: ChildSrInformationComponent
            },
            {
                path: 'sr-hierarchy',
                component: SrHierarchyComponent
            }
        ]
    },
    {
        path: 'connection-design-search',
        component: ConnectionSearchFormComponent
    },
    {
        // TODO: The path needs to include search parameters
        path: 'connection-search-results',
        component: ConnectionSearchResultsComponent
    },
    {
        path: 'circuit-design-details/circuit-id/:circuitDesignId',
        component: CircuitDesignDetailsComponent,
        children: [
            {
                path: 'issue-num/:issueNbr/doc-num/:docNum',
                component: ConnectionDesignDetailComponent,
                children: [
                    {
                        path: '',
                        pathMatch: 'full',
                        redirectTo: 'circuit-details'
                    },
                    {
                        path: 'circuit-details',
                        component: CircuitDetailsComponent
                    },
                    {
                        path: 'administrative-section',
                        component: AdministrativeSectionComponent
                    },
                    {
                        path: 'design-section',
                        component: DesignSectionComponent
                    },
                    {
                        path: 'eu-termination',
                        component: EuTerminationComponent
                    },
                    {
                        path: 'notes-section',
                        component: NotesSectionComponent
                    },
                    {
                        path: 'design-lines',
                        component: DesignLinesComponent
                    },
                    {
                        path: 'circuit-xref',
                        component: CircuitXrefSectionComponent
                    }
                ]
            }
        ]
    },
    {
        path: 'connection-hierarchy',
        component: ConnectionHierarchySearchComponent
    },
    {
        path: 'connection-hierarchy-search-results/:lookupChildren',
        component: ConnectionHierarchySearchResultsComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class TopRoutingModule {
}
