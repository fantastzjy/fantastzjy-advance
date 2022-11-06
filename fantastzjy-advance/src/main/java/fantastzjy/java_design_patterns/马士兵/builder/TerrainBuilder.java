package fantastzjy.java_design_patterns.马士兵.builder;

public interface TerrainBuilder {
    TerrainBuilder buildWall();

    TerrainBuilder buildFort();

    TerrainBuilder buildMine();

    Terrain build();
}
