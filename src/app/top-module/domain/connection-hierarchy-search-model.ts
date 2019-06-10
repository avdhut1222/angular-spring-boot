export interface ConnectionHierarchySearchModel {
    ecckt: string;
    eccktExactMatch: boolean;
    connectionReference: string;
    connXrefExactMatch: boolean;
    locationA: string;
    locationAExactMatch: boolean;
    locationZ: string;
    locationZExactMatch: boolean;
    circuitTypes: string[];
    lookupChildren: boolean;
}
