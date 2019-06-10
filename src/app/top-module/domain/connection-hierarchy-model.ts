export interface ConnectionHierarchyModel {
    circuitDesignId: number;
    circuitId: string;
    circuitType: string;
    status: string;
    children: ConnectionHierarchyModel[];
    parents: ConnectionHierarchyModel[];
    
}
